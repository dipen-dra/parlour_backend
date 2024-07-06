package com.example.parlour_back.service;

import com.example.parlour_back.entity.Customer;
import com.example.parlour_back.pojo.CustomerPojo;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerPojo customerPojo);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long customer_id);
    Customer updateCustomerById(Long customer_id, CustomerPojo customerPojo);
    void deleteCustomerById(Long customer_id);



}