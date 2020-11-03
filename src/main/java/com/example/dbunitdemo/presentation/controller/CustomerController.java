package com.example.dbunitdemo.presentation.controller;

import com.example.dbunitdemo.domain.model.Customer;
import com.example.dbunitdemo.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("customers")
    public List<Customer> getAll() {
        return customerService.findAll();
    }
}
