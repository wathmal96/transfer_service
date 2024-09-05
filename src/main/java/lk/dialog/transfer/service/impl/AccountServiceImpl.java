package lk.dialog.transfer.service.impl;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.repo.AccountRepo;
import lk.dialog.transfer.service.AccountService;
import lk.dialog.transfer.util.impl.ConverterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final ConverterImpl converterImpl;

    @Override
    public AccountDto getAccountDetails(String accountNumber) {
        Account account = accountRepo.getAccountByAccountNumber(accountNumber);
        if (account != null)
            return converterImpl.accountToDto(account);
        return null;
    }
}
