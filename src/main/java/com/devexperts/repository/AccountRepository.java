package com.devexperts.repository;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountKey> {
}
