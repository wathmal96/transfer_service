package lk.dialog.transfer.controller;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/make-transaction")
    public ResponseEntity<Object> makeTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto transfer = transactionService.transfer(transactionDto);
        if (transfer != null)
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);
        return new ResponseEntity<>("Transaction Failed. Check Account Balance !", HttpStatus.BAD_REQUEST);
    }
}
