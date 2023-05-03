package com.daofab.exercise.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class TransactionController implements TransactionApi{

    private final TransactionService transactionService;

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(int page, long sortField) {
        return transactionService.getTransaction(page, sortField);
    }
}
