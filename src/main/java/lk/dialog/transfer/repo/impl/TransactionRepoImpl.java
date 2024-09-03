package lk.dialog.transfer.repo.impl;

import lk.dialog.transfer.db.InMemoryDb;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.repo.TransactionRepo;
import org.springframework.stereotype.Component;

@Component
public class TransactionRepoImpl implements TransactionRepo {
    private final InMemoryDb inMemoryDb;

    public TransactionRepoImpl(InMemoryDb inMemoryDb) {
        this.inMemoryDb = inMemoryDb;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        boolean add = inMemoryDb.getTransactions().add(transaction);
        if (add) {
            return transaction;
        }
        return null;
    }
}
