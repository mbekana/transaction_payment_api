package com.daofab.exercise.transaction.payment;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<PaymentDto> getPaymentDetails(long parentId);
}
