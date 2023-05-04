package com.daofab.exercise.transaction.payment;

import com.daofab.exercise.transaction.DataReader;
import com.daofab.exercise.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final DataReader dataReader;

    @Override
    public List<PaymentDto> getPaymentDetails(long parentId) {
        List<Transaction> transactions = dataReader.getTransactionList();
        List<Payment> payments = dataReader.getPaymentList().stream()
                .filter(payment -> payment.getParentId() == parentId)
                .collect(Collectors.toList());

            // Group transactions by transaction id for easy lookup
            Map<Long, Transaction> transactionMap = transactions.stream()
                    .collect(Collectors.toMap(Transaction::getId, Function.identity()));

            // Create PaymentDto objects for each payment
            List<PaymentDto> paymentDtos = payments.stream()
                    .map(payment -> {
                        Transaction transaction = transactionMap.get(payment.getParentId());
                        return new PaymentDto(
                                payment.getId(),
                                transaction.getSender(),
                                transaction.getReceiver(),
                                payment.getPaidAmount(),
                                transaction.getTotalAmount()
                        );
                    })
                    .collect(Collectors.toList());

            return paymentDtos;
        }

    }
