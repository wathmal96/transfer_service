package lk.dialog.transfer.db;

import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class InMemoryDb {
    private final Map<String, Account> accounts;
    private final List<Transaction> transactions;

    public InMemoryDb() {
        this.accounts = new HashMap<>();
        this.transactions = new ArrayList<>();
        accounts.put("AC001", new Account("AC001", 1000));
        accounts.put("AC002", new Account("AC002", 3000));
        accounts.put("AC003", new Account("AC003", 2000));
    }
}
