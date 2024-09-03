package lk.dialog.transfer.controller;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> getAccountDetails(@PathVariable String accountNumber) {
        AccountDto accountDetails = accountService.getAccountDetails(accountNumber);
        if (accountDetails != null)
            return new ResponseEntity<>(accountDetails, HttpStatus.OK);
        return new ResponseEntity<>("Account not found",HttpStatus.BAD_REQUEST);
    }
}
