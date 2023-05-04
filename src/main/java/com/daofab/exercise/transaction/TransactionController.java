package com.daofab.exercise.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class TransactionController implements TransactionApi{

    @Autowired
    public TransactionService transactionService;

    @Override
    public ResponseEntity<Page<TransactionDto>> getTransactions(int page, int size,  String sort) {
        return  ResponseEntity.ok(transactionService.getTransaction(page, 2, sort));
    }
}
