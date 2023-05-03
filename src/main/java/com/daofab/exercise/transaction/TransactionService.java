package com.daofab.exercise.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    List<Transaction> getTransaction(int page, int size, String sortField);
}
