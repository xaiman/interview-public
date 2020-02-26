package com.devexperts;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAccounts {

    @Autowired
    private AccountService accountService;

    private Account account;

    @Before
    public void before(){
        account = new Account(AccountKey.valueOf(124L),
                "Test2",
                "Testov2",
                5000.00);
    }

    @Test
    public void testCreate(){
        accountService.createAccount(account);
        Assert.assertNotNull(accountService.getAccount(123L));
    }

    @Test
    public void testGet(){
        Assert.assertNotNull(accountService.getAccount(123L));
    }

    @Test
    public void testDelte(){
        accountService.clear();
        Assert.assertNull(accountService.getAccount(123L));
    }

}
