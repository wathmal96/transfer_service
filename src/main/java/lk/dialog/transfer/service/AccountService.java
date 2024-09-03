package lk.dialog.transfer.service;

import lk.dialog.transfer.dto.AccountDto;
import org.springframework.stereotype.Service;

public interface AccountService {
    AccountDto getAccountDetails(String accountNumber);
}
