package com.example.parlour_back.service.impl;

import com.example.parlour_back.entity.Customer;
import com.example.parlour_back.pojo.CustomerPojo;
import com.example.parlour_back.repository.CustomerRepository;
import com.example.parlour_back.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerPojo customerPojo) {
        Customer customer = new Customer();
        customer.setFullName(customerPojo.getFullName());
        customer.setEmail(customerPojo.getEmail());
        customer.setPhoneNumber(customerPojo.getPhoneNumber());
        customer.setPassword(String.valueOf(customerPojo.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return  customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customer_id) {
        return null;
    }

    @Override
    public Customer updateCustomerById(Long customer_id, CustomerPojo customerPojo) {
        Optional<Customer> customer = customerRepository.findById(customer_id);
        if (customer.isPresent()) {
            customer.get().setFullName(customerPojo.getFullName());
            customer.get().setEmail(customerPojo.getEmail());
            customer.get().setPhoneNumber(customerPojo.getPhoneNumber());
            customer.get().setPassword(String.valueOf(customerPojo.getPassword()));
            return customerRepository.save(customer.get());
        }else{
            return null;
        }

    }

    @Override
    public void deleteCustomerById(Long customer_id) {
        customerRepository.deleteById(customer_id);

    }
}