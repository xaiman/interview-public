package com.devexperts.rest;

import com.devexperts.account.Account;
import com.devexperts.account.Transfer;
import com.devexperts.exception.WrongAccountBalance;
import com.devexperts.repository.TransferRepository;
import com.devexperts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController extends AbstractAccountController {

    @NotNull
    private final AccountService accountService;

    @NotNull
    private final TransferRepository transferRepository;

    @PostMapping("/operations/transfer")
    public ResponseEntity<Void> transfer(@RequestParam long sourceId,
                                         @RequestParam long targetId,
                                         @RequestParam double amount)
    throws InterruptedException, ExecutionException {
        Account sourceAccount = accountService.getAccount(sourceId);
        if (amount > 0 && sourceAccount.getBalance() >= amount && accountService.transfer(sourceAccount,
                    accountService.getAccount(targetId),
                    amount)) {
            Transfer transfer = new Transfer(sourceId, targetId, amount);
            transferRepository.save(transfer);
            return ResponseEntity.ok().build();
        }
        throw new WrongAccountBalance("insufficient account balance");
    }
}
