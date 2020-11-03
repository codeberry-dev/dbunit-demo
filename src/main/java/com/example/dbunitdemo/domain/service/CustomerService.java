package com.example.dbunitdemo.domain.service;

import com.example.dbunitdemo.domain.model.Customer;
import com.example.dbunitdemo.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByPk(Long id) {
        return customerRepository.get(id);
    }

    public int create(Customer customer) {
        return customerRepository.create(customer);
    }

    public int update(Customer customer) {
        return customerRepository.update(customer);
    }

    public int delete(Long id) {
        return customerRepository.delete(id);
    }
}
