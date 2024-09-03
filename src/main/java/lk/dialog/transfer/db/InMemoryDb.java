package lk.dialog.transfer.db;

import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDb {
    private final ArrayList<Account> accounts;
    private final ArrayList<Transaction> transactions;

    public InMemoryDb() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        accounts.add(new Account("AC001", 1000));
        accounts.add(new Account("AC002", 3000));
        accounts.add(new Account("AC003", 2000));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
