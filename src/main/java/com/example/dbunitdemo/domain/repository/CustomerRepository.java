package com.example.dbunitdemo.domain.repository;

import com.example.dbunitdemo.domain.mapper.CustomerMapper;
import com.example.dbunitdemo.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    public Customer get(Long id) {
        return customerMapper.get(id);
    }

    public int create(Customer customer) {
        return customerMapper.insert(customer);
    }

    public int update(Customer customer) {
        return customerMapper.update(customer);
    }

    public int delete(Long id) {
        return customerMapper.delete(id);
    }

}
