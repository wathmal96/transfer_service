package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;

    @Override
    public AccountDto getAccountDetails(String accountNumber) {
        Account account = accountRepo.getAccountByAccountNumber(accountNumber);
        if (account != null)
            return new AccountDto(account.getAccountNumber(), account.getBalance());
        return null;
    }
}
