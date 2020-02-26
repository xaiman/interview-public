package com.devexperts.account;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Unique Account identifier
 *
 * <p>
 * NOTE: we suspect that later {@link #accountId} is not going to be uniquely identifying an account,
 * as we might add human-readable account representation and some clearing codes for partners.
 * */
@Embeddable
public class AccountKey implements Serializable {
    private long accountId;

    private AccountKey(){

    }

    private AccountKey(long accountId) {
        this.accountId = accountId;
    }

    public static AccountKey valueOf(long accountId) {
        return new AccountKey(accountId);
    }
}
