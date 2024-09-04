package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.repo.TransactionRepo;
import lk.dialog.transfer.service.TransactionService;
import lk.dialog.transfer.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    private final Converter converter;

    @Override
    public TransactionDto transfer(TransactionDto transactionDto) {
        if (transactionDto.getSourceAccount().equals(transactionDto.getDestinationAccount()))
            return null;
        Account sourceAccount = accountRepo.getAccountByAccountNumber(transactionDto.getSourceAccount());
        Account destinationAccount = accountRepo.getAccountByAccountNumber(transactionDto.getDestinationAccount());

        if (sourceAccount==null || destinationAccount==null || sourceAccount.getBalance()<transactionDto.getAmount())
            return null;
        //store transaction
        Transaction transaction = transactionRepo.saveTransaction(converter.transactionDtoToModel(transactionDto));

        //decrement amount from source account
        sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());

        //increment destination account
        destinationAccount.setBalance(destinationAccount.getBalance() + transaction.getAmount());

        return converter.transactionToDto(transaction);

    }
}
