package com.daofab.exercise.transaction;

import com.daofab.exercise.transaction.payment.Payment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataReader {
    public static List<Transaction> readParentData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("Parent.json").getFile();
        return mapper.readValue(file, new TypeReference<List<Transaction>>(){});
    }

    public static List<Payment> readChildData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new ClassPathResource("Child.json").getFile();
        return mapper.readValue(file, new TypeReference<List<Payment>>(){});
    }
}
