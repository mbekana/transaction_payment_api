package com.daofab.exercise.transaction.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String sender;
    private String receiver;
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
}
