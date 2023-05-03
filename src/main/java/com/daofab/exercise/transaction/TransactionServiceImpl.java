package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.Payment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TransactionServiceImpl implements TransactionService{
    private List<Transaction> transactionList;
    private List<Payment> paymentList;

    public TransactionServiceImpl() {
        // Load data from JSON files in the resources folder
        ObjectMapper mapper = new ObjectMapper();

        try {
            transactionList = Arrays.asList(mapper.readValue(
                    new ClassPathResource("Parent.json").getInputStream(),
                    Transaction[].class));
            System.out.println(transactionList + "Transaction List");
            paymentList = Arrays.asList(mapper.readValue(
                    new ClassPathResource("Child.json").getInputStream(),
                    Payment[].class));
            System.out.println(paymentList + "Payment List");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Page<Transaction>getTransaction(int page, int  size, String sortBy)  {
        // Get parent transactions with total amount and total paid amount
        List<Transaction> parentTransactionList = transactionList.stream()
                .map(t -> new Transaction(
                        t.getId(),
                        t.getSender(),
                        t.getReceiver(),
                        t.getTotalAmount(),
                        paymentList.stream()
                                .filter(p -> p.getParentId() == t.getId())
                                .map(Payment::getPaidAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .sorted(Comparator.comparing(Transaction::getId))
                .collect(Collectors.toList());
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        if (sortBy != null && !sortBy.isEmpty()) {
            sort = Sort.by(sortBy);
        }
        // Create page object for server-side pagination
        Page<Transaction> parentTransactionPage = new PageImpl<>(
                parentTransactionList.stream()
                        .skip(page * size)
                        .limit(size)
                        .collect(Collectors.toList()),
                PageRequest.of(page, size, sort),
                parentTransactionList.size());

        return parentTransactionPage;

    }
}
