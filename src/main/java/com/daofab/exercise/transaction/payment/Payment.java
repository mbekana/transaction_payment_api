package com.daofab.exercise.transaction.payment;

import com.daofab.exercise.transaction.Transaction;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//@Entity(name = "ChildTransaction")
//@Table(name = "payments")
@Data
public class Payment {
    private Long id;
    private Long parentId;
    private BigDecimal paidAmount;
}
