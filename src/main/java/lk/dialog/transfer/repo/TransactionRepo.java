package lk.dialog.transfer.repo;

import lk.dialog.transfer.model.Transaction;

public interface TransactionRepo {
    Transaction saveTransaction(Transaction transaction);
}
