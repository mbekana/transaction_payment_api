package com.daofab.exercise.transaction.payment;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

public interface PaymentAPi {

    @GetMapping("/{parentId}/children")
    public ResponseEntity<List<PaymentDto>> getChildren(@PathVariable Long parentId);


}
