package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Override
    public AccountDto getAccountDetails(String accountNumber) {
        Account account = accountRepo.getAccountByAccountNumber(accountNumber);
        if (account!=null)
            return new AccountDto(account.getAccountNumber(),account.getBalance());
        return null;
    }
}
