package com.zte.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository){
        return (args -> {
            deleteJavaAdvocates(repository);
            insertJavaAdvocates(repository);
            System.out.println(repository.findAll());
            System.out.println(repository.findEmployeeByLastNameContaining("g"));
        });
    }

    private void insertJavaAdvocates(EmployeeRepository repository){
        repository.save(new Employee("Kris", "Hagenes"));
        repository.save(new Employee("Marcelina", "Cummerata"));
        repository.save(new Employee("Geoffrey", "Wiegand"));
    }

    private void deleteJavaAdvocates(EmployeeRepository repository){
        repository.deleteAll();
    }
}
