package com.daofab.exercise.transaction.payment;

import com.daofab.exercise.transaction.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class PaymentController implements PaymentAPi{

   private final PaymentService paymentService;
    @Override
    public ResponseEntity<List<PaymentDto>> getChildren(Long parentId) {
        return ResponseEntity.ok(paymentService.getPaymentDetails(parentId));
    }
}
