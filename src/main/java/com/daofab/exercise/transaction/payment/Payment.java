package com.daofab.exercise.transaction.payment;

import com.daofab.exercise.transaction.Transaction;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ChildTransaction")
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Transaction parent;
    private BigDecimal paidAmount;
}
