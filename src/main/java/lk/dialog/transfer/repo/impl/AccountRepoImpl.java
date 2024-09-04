package lk.dialog.transfer.repo.impl;

import lk.dialog.transfer.db.InMemoryDb;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {
    private final InMemoryDb inMemoryDb;

    @Override
    public Account getAccountByAccountNumber(String accNumber) {
        Map<String, Account> accounts = inMemoryDb.getAccounts();
        return accounts.get(accNumber);
    }
}
