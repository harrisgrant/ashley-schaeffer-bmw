package com.claim.ashleyschaefferbmw.controller;

import com.claim.ashleyschaefferbmw.entity.Customer;
import com.claim.ashleyschaefferbmw.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer findCustomerById(@PathVariable Integer customerId) {
        return customerService.findCustomerByCustomerId(customerId);
    }

    @PostMapping("/customers")
    public Customer insertCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

    @DeleteMapping("/customers/{customerId}")
    public Boolean deleteCustomer(@PathVariable Integer customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
