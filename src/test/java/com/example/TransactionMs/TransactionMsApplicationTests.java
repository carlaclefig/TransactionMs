package com.example.TransactionMs;

import com.example.TransactionMs.model.Transaction;
import com.example.TransactionMs.repository.TransactionRepository;
import com.example.TransactionMs.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@SpringBootTest
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        // Crear un objeto de transacción para las pruebas
        transaction = new Transaction();
        transaction.setAmount(100.0);  // Asumimos que 'amount' es un campo de tipo Double
        transaction.setType("Deposit");  // Asumimos que 'type' es un campo String
    }

    @Test
    void deposit_shouldSaveTransaction() {
        // Simula que el repositorio guarda la transacción
        when(transactionRepository.save(any(Transaction.class))).thenReturn(Mono.just(transaction));

        // Llamada al método y verificación
        Mono<Transaction> result = transactionService.deposit(transaction);

        // Verifica que el repositorio haya sido llamado y que se retorna la transacción
        result.doOnTerminate(() -> verify(transactionRepository, times(1)).save(transaction)).block();
    }

    @Test
    void withdraw_shouldSaveTransaction() {
        // Simula que el repositorio guarda la transacción
        when(transactionRepository.save(any(Transaction.class))).thenReturn(Mono.just(transaction));

        // Llamada al método y verificación
        Mono<Transaction> result = transactionService.withdraw(transaction);

        // Verifica que el repositorio haya sido llamado y que se retorna la transacción
        result.doOnTerminate(() -> verify(transactionRepository, times(1)).save(transaction)).block();
    }

    @Test
    void transfer_shouldSaveTransaction() {
        // Simula que el repositorio guarda la transacción
        when(transactionRepository.save(any(Transaction.class))).thenReturn(Mono.just(transaction));

        // Llamada al método y verificación
        Mono<Transaction> result = transactionService.transfer(transaction);

        // Verifica que el repositorio haya sido llamado y que se retorna la transacción
        result.doOnTerminate(() -> verify(transactionRepository, times(1)).save(transaction)).block();
    }

    @Test
    void getAllTransactions_shouldReturnAllTransactions() {
        // Simula que el repositorio devuelve una lista de transacciones
        when(transactionRepository.findAll()).thenReturn(reactor.core.publisher.Flux.just(transaction));

        // Llamada al método y verificación
        reactor.core.publisher.Flux<Transaction> result = transactionService.getAllTransactions();

        // Verifica que el repositorio haya sido llamado y que se retorne la lista
        result.doOnTerminate(() -> verify(transactionRepository, times(1)).findAll()).blockLast();
    }
}
