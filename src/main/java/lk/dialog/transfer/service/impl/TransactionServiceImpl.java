package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.repo.TransactionRepo;
import lk.dialog.transfer.service.TransactionService;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(AccountRepo accountRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }


    @Override
    public TransactionDto transfer(TransactionDto transactionDto) {
        Account sourceAccount = accountRepo.getAccountByAccountNumber(transactionDto.getSourceAcc());
        Account destinationAccount = accountRepo.getAccountByAccountNumber(transactionDto.getDestinationAcc());

        if (sourceAccount == null || destinationAccount == null) {
            return null;
        }

        //store transaction
        if (sourceAccount.getBalance() > transactionDto.getAmount()) {
            Transaction transaction = transactionRepo.saveTransaction(new Transaction(transactionDto.getSourceAcc(),
                    transactionDto.getDestinationAcc(), transactionDto.getAmount()));

            //decrement amount from source account
            sourceAccount.setBalance(sourceAccount.getBalance() - transactionDto.getAmount());

            //increment destination account
            destinationAccount.setBalance(destinationAccount.getBalance() + transactionDto.getAmount());

            return new TransactionDto(transaction.getSourceAccountNUmber(),
                    transactionDto.getDestinationAcc(), transactionDto.getAmount());
        }
        return null;
    }
}
