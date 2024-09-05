package lk.dialog.transfer.service;

import lk.dialog.transfer.dto.AccountDto;

public interface AccountService {
    AccountDto getAccountDetails(String accountNumber);
}
