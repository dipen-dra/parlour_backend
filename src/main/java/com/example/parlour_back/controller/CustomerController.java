package com.example.parlour_back.controller;

import com.example.parlour_back.entity.Customer;
import com.example.parlour_back.pojo.CustomerPojo;
import com.example.parlour_back.service.CustomerService;
import com.example.parlour_back.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor

public class CustomerController {
    private  final CustomerService customerService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Customer>> createCustomer(@RequestBody CustomerPojo customerPojo) {
        Customer customer = customerService.createCustomer(customerPojo);
        GlobalApiResponse<Customer> response=new GlobalApiResponse<>("successfully added",200,customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<Customer>>> getAllCustomer() {
        List<Customer> customer = customerService.getAllCustomer();
        GlobalApiResponse<List<Customer>> response = new GlobalApiResponse<>("customers retrieved successfully",200,customer);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Customer>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            GlobalApiResponse<Customer> response = GlobalApiResponse.<Customer>builder()
                    .message("Customer not found with id " + id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Customer> response = GlobalApiResponse.<Customer>builder()
                .message("Customer retrieved successfully")
                .statusCode(HttpStatus.OK.value())
                .data(customer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Customer>> updateCustomerById(@PathVariable Long id, @RequestBody CustomerPojo customerPojo) {
        Customer updatedCustomer = customerService.updateCustomerById(id, customerPojo);
        if (updatedCustomer == null) {
            GlobalApiResponse<Customer> response = GlobalApiResponse.<Customer>builder()
                    .message("Customer not found with id " + id)
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GlobalApiResponse<Customer> response = GlobalApiResponse.<Customer>builder()
                .message("Customer updated successfully")
                .statusCode(HttpStatus.OK.value())
                .data(updatedCustomer)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        GlobalApiResponse<Void> response = GlobalApiResponse.<Void>builder()
                .message("Customer deleted successfully")
                .statusCode(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}