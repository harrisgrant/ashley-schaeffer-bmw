package com.claim.ashleyschaefferbmw.services;

import com.claim.ashleyschaefferbmw.entity.Customer;
import com.claim.ashleyschaefferbmw.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer findCustomerByCustomerId(Integer customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }


    public Customer addCustomer(Customer customer) {
        Customer addCustomer = new Customer(customer.getCustomerId(), customer.getFirstName(),
                customer.getLastName(), customer.getPhone(), customer.getAddress());
        return customerRepository.save(addCustomer);
    }


    public Customer updateCustomer(Customer customer, Integer customerId) {
        Customer updateCustomer = customerRepository.findCustomerByCustomerId(customerId);
        if (customer == null) { return null; }
        customer.setCustomerId(customer.getCustomerId());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setAddress(customer.getAddress());
        customer.setPhone(customer.getPhone());
        return customerRepository.save(updateCustomer);
    }


    public Boolean deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        if (customer != null) { customerRepository.delete(customer); }
        return true;
    }
}

