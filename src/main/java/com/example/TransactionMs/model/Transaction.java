
package com.example.TransactionMs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String type; // Deposit, Withdraw, Transfer
    private double amount;
    private String sourceAccount;
    private String destinationAccount;
    private LocalDateTime date = LocalDateTime.now();
}
