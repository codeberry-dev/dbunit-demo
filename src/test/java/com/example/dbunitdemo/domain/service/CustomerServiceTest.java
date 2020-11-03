package com.example.dbunitdemo.domain.service;

import com.example.dbunitdemo.domain.model.Customer;
import com.example.dbunitdemo.util.CsvDataSetLoader;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootTest
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class
})
@Transactional
class CustomerServiceTest {

  @Autowired private CustomerService customerService;

  @Test
  @DatabaseSetup("/testdata/CustomerServiceTest/init-data")
  @ExpectedDatabase("/testdata/CustomerServiceTest/init-data")
  void findByPk() {
    // 期待値
    Customer expect = Customer.builder()
            .id(3L)
            .name("三郎")
            .age(20)
            .address("神奈川")
            .build();
    // 実際値
    Customer actual = customerService.findByPk(3L);

    log.info("expect = {}", expect);
    log.info("actual = {}", actual);
    Assertions.assertEquals(expect, actual);
  }

  @Test
  @DatabaseSetup("/testdata/CustomerServiceTest/init-data")
  @ExpectedDatabase("/testdata/CustomerServiceTest/init-data")
  void findAll() {
    List<Customer> customers = customerService.findAll();
    log.info("actual customers = {}", customers);
    Assertions.assertEquals(4, customers.size());
  }

  @Test
  @DatabaseSetup("/testdata/CustomerServiceTest/init-data")
  @ExpectedDatabase("/testdata/CustomerServiceTest/after-create-data")
  void create() {
    Customer newCustomer = Customer.builder()
            .name("五郎")
            .age(15)
            .build();
    int result = customerService.create(newCustomer);
    List<Customer> customers = customerService.findAll();
    log.info("newCustomer id = {}", newCustomer.getId());
    log.info("result = {}, customers = {}", result, customers);
    Assertions.assertEquals(5, customers.size());
  }

  @Test
  @DatabaseSetup("/testdata/CustomerServiceTest/init-data")
  @ExpectedDatabase("/testdata/CustomerServiceTest/after-update-data")
  void update() {
    Customer updateCustomer = Customer.builder()
            .id(2L)
            .name("二郎")
            .age(29)
            .build();
    int result = customerService.update(updateCustomer);
    List<Customer> customers = customerService.findAll();
    log.info("result = {}, customers = {}", result, customers);
    Assertions.assertEquals(4, customers.size());
  }

  @Test
  @DatabaseSetup("/testdata/CustomerServiceTest/init-data")
  @ExpectedDatabase("/testdata/CustomerServiceTest/after-delete-data")
  void delete() {
    int result = customerService.delete(1L);
    List<Customer> customers = customerService.findAll();
    log.info("result = {}, customers = {}", result, customers);
    Assertions.assertEquals(3, customers.size());
  }

}
