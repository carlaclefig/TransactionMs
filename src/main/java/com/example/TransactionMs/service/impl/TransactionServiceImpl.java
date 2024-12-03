
package com.example.TransactionMs.service.impl;

import com.example.TransactionMs.model.Transaction;
import com.example.TransactionMs.repository.TransactionRepository;
import com.example.TransactionMs.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Mono<Transaction> deposit(Transaction transaction) {
        transaction.setType("Deposit");
        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> withdraw(Transaction transaction) {
        transaction.setType("Withdraw");
        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> transfer(Transaction transaction) {
        transaction.setType("Transfer");
        return transactionRepository.save(transaction);
    }

    @Override
    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
