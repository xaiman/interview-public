package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.exception.AccountNotFound;
import com.devexperts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl implements AccountService {

    @NotNull
    private final AccountRepository accountRepository;

    @Override
    public void clear() {
        accountRepository.deleteAll();
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.saveAndFlush(account);
    }

    @Override
    public Account getAccount(long id) {
        return accountRepository.findById(AccountKey.valueOf(id))
                .orElseThrow(() -> new AccountNotFound("account is not found"));
    }

    @Override
    public Boolean transfer(Account source,
                            Account target,
                            double amount) throws InterruptedException,
            ExecutionException {
        Executor executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Boolean> completableFuture = CompletableFuture.supplyAsync(() -> {
            source.withdraw(amount);
            target.deposit(amount);
            return true;
        }, executor);
        return completableFuture.get();
    }

}
