package com.example.dbunitdemo.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {
    private Long id;
    private String name;
    private Integer age;
    private String address;
}
