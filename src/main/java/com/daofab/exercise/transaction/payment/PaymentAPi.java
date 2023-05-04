package com.daofab.exercise.transaction.payment;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface PaymentAPi {

    @GetMapping("/{parentId}/payment-details")
    public ResponseEntity<List<PaymentDto>> getChildren(@PathVariable Long parentId);


}
