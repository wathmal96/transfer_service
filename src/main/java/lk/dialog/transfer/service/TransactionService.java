package lk.dialog.transfer.service;

import lk.dialog.transfer.dto.TransactionDto;

public interface TransactionService {
    TransactionDto transfer(TransactionDto transactionDto);
}
