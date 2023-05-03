package com.daofab.exercise.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private BigDecimal totalAmount;
    private BigDecimal totalPaidAmount;

    public Transaction(@JsonProperty("id") Long id,
                       @JsonProperty("sender") String sender,
                       @JsonProperty("receiver") String receiver,
                       @JsonProperty("totalAmount") BigDecimal totalAmount,
                       @JsonProperty("totalPaidAmount") BigDecimal totalPaidAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.totalPaidAmount = totalPaidAmount;
    }
}
