package lk.dialog.transfer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    String sourceAccountNumber;
    String destinationAccountNumber;
    Double amount;
}
