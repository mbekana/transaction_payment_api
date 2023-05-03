package com.daofab.exercise.transaction.payment;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    List<Payment> findByParentIdOrderByid(Long parentId);
}