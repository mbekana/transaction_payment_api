package com.daofab.exercise.transaction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService{
    private List<Transaction> transaction;

    public TransactionServiceImpl() throws IOException {
        transaction = DataReader.readParentData();

    }


    @Override
    public List<Transaction> getTransaction(int page, int size, String sortField) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortField));
        List<Transaction> paginatedList = transaction.stream()
                .sorted(Comparator.comparing(Transaction::getId))
                .skip(pageable.getOffset())
                .limit(pageable.getPageSize())
                .collect(Collectors.toList());
        return paginatedList;
    }
}
