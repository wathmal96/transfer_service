package lk.dialog.transfer.repo.impl;

import lk.dialog.transfer.db.InMemoryDb;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransactionRepoImpl implements TransactionRepo {
    private final InMemoryDb inMemoryDb;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        inMemoryDb.getTransactions().add(transaction);
        return transaction;
    }
}
