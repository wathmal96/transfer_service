package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.repo.TransactionRepo;
import lk.dialog.transfer.service.TransactionService;
import lk.dialog.transfer.util.impl.ConverterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    private final ConverterImpl converterImpl;

    @Override
    public TransactionDto transfer(TransactionDto transactionDto) {
        if (isInvalidDestination(transactionDto)) return null;
        if (isInvalidAmount(transactionDto)) return null;

        Account sourceAccount = accountRepo.getAccountByAccountNumber(transactionDto.getSourceAccount());
        Account destinationAccount = accountRepo.getAccountByAccountNumber(transactionDto.getDestinationAccount());

        if (isInvalidData(sourceAccount, destinationAccount, transactionDto)) return null;

        //store transaction
        Transaction transaction = transactionRepo.saveTransaction(converterImpl.transactionDtoToModel(transactionDto));

        //decrement amount from source account
        sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());

        //increment destination account
        destinationAccount.setBalance(destinationAccount.getBalance() + transaction.getAmount());

        return converterImpl.transactionToDto(transaction);
    }

    private boolean isInvalidData(Account sourceAccount, Account destinationAccount, TransactionDto transactionDto) {
        return sourceAccount == null ||
                destinationAccount == null ||
                transactionDto.getAmount() > sourceAccount.getBalance();
    }

    private boolean isInvalidDestination(TransactionDto transactionDto) {
        return transactionDto.getSourceAccount().equals(transactionDto.getDestinationAccount());
    }

    private boolean isInvalidAmount(TransactionDto transactionDto) {
        return transactionDto.getAmount() <= 0;
    }
}
