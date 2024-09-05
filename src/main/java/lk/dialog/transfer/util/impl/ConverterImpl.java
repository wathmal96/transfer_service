package lk.dialog.transfer.util.impl;

import lk.dialog.transfer.dto.AccountDto;
import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Account;
import lk.dialog.transfer.model.Transaction;
import lk.dialog.transfer.util.Converter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterImpl implements Converter {
    private final ModelMapper modelMapper;
    public Transaction transactionDtoToModel(TransactionDto transactionDto) {
        return modelMapper.map(transactionDto, Transaction.class);
    }
    public TransactionDto transactionToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }
    public AccountDto accountToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }
}
