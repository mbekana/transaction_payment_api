package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionApi {
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "id") String sortField);

}
