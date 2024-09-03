package lk.dialog.transfer.repo;

import lk.dialog.transfer.model.Account;

public interface AccountRepo {
    Account getAccountByAccountNumber(String accNumber);
}
