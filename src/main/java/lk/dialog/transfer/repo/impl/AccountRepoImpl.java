package lk.dialog.transfer.repo.impl;

import lk.dialog.transfer.db.InMemoryDb;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.repo.AccountRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRepoImpl implements AccountRepo {
    private final InMemoryDb inMemoryDb;

    public AccountRepoImpl(InMemoryDb inMemoryDb) {
        this.inMemoryDb = inMemoryDb;
    }

    @Override
    public Account getAccountByAccountNumber(String accNumber) {
        List<Account> accounts = inMemoryDb.getAccounts();

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNumber)) {
                return acc;
            }
        }
        return null;
    }
}
