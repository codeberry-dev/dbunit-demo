package com.example.dbunitdemo.domain.mapper;

import com.example.dbunitdemo.domain.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> findAll();
    Customer get(@Param("id") Long id);
    int insert(@Param("customer") Customer customer);
    int update(@Param("customer") Customer customer);
    int delete(@Param("id") Long id);
}
