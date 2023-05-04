package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.Payment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final DataReader dataReader;

    @Override
    public Page<TransactionDto> getTransaction(int page, int size, String sortBy) {
        // Get lists of Transaction and Payment objects from DataReader
        List<Transaction> transactionList = dataReader.getTransactionList();
        List<Payment> paymentList = dataReader.getPaymentList();

        // Get parent transactions with total amount and total paid amount
        List<TransactionDto> parentTransactionList = transactionList.stream()
                .map(t -> new TransactionDto(
                        t.getId(),
                        t.getSender(),
                        t.getReceiver(),
                        t.getTotalAmount(),
                        paymentList.stream()
                                .filter(p -> p.getParentId() == t.getId())
                                .map(Payment::getPaidAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .sorted(Comparator.comparing(TransactionDto::getId))
                .collect(Collectors.toList());

        // Set default sort order to ascending by id
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        // If a sortBy parameter is provided, update the sort order accordingly
        if (sortBy != null && !sortBy.isEmpty()) {
            sort = Sort.by(sortBy);
        }

        // Create page object for server-side pagination
        Page<TransactionDto> parentTransactionPage = new PageImpl<>(
                parentTransactionList.stream()
                        .skip(page * size)
                        .limit(size)
                        .collect(Collectors.toList()),  // List of TransactionDto objects for current page
                PageRequest.of(page, size, sort),  // PageRequest object with current page number, page size, and sort order
                parentTransactionList.size());  // Total number of TransactionDto objects

        return parentTransactionPage;
    }
}
