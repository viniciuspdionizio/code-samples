package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerTests {

    @Autowired
    private CustomerRepository repo;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Test
    @Transactional
    public void shouldInsertCustomer() {
        var customer = new Customer();
        customer.setName("Vinicius");

        customer = this.repo.save(customer);

        assertNotNull(customer.getId());
    }

}
