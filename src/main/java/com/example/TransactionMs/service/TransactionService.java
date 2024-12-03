
package com.example.TransactionMs.service;

import com.example.TransactionMs.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<Transaction> deposit(Transaction transaction);
    Mono<Transaction> withdraw(Transaction transaction);
    Mono<Transaction> transfer(Transaction transaction);
    Flux<Transaction> getAllTransactions();
}
