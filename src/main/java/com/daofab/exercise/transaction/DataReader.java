package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.Payment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Data
@Component
public class DataReader {
    // Initialize lists to hold Transaction and Payment objects
    private List<Transaction> transactionList;
    private List<Payment> paymentList;

    public DataReader() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read in Transaction objects from Parent.json and store in list
            transactionList = Arrays.asList(mapper.readValue(
                    new ClassPathResource("Parent.json").getInputStream(),
                    Transaction[].class));
            // Read in Payment objects from Child.json and store in list
            paymentList = Arrays.asList(mapper.readValue(
                    new ClassPathResource("Child.json").getInputStream(),
                    Payment[].class));
        } catch (IOException e) {
            // Print error if there is an issue with reading in the data
            e.printStackTrace();
        }
    }

    // Getter method for Transaction list
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    // Getter method for Payment list
    public List<Payment> getPaymentList() {
        return paymentList;
    }
}
