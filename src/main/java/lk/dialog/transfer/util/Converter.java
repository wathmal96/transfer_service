package lk.dialog.transfer.util;

import lk.dialog.transfer.dto.TransactionDto;
import lk.dialog.transfer.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;
    public Transaction transactionDtoToModel(TransactionDto transactionDto) {
        return modelMapper.map(transactionDto, Transaction.class);
    }
    public TransactionDto transactionToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }
}
