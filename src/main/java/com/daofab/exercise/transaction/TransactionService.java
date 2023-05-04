package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    Page<TransactionDto> getTransaction(int page, int size,  String sortBy);

 }
