package lk.dialog.transfer.controller;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Object> makeTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto transfer = transactionService.transfer(transactionDto);
        if (transfer != null)
            return new ResponseEntity<>(transfer, HttpStatus.CREATED);
        return new ResponseEntity<>("Transaction Failed", HttpStatus.BAD_REQUEST);
    }
}
