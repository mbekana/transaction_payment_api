package com.daofab.exercise.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    Page<Transaction> getTransaction(int page, int size,  String sortBy);
}
