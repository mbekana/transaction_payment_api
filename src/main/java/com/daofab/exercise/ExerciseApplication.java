package com.daofab.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ExerciseApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

}
