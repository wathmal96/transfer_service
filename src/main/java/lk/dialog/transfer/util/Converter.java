package lk.dialog.transfer.util;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;

public interface Converter {
    Transaction transactionDtoToModel(TransactionDto transactionDto);
    TransactionDto transactionToDto(Transaction transaction);
    AccountDto accountToDto(Account account);
}
