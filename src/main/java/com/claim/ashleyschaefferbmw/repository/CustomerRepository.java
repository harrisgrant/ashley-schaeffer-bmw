package com.claim.ashleyschaefferbmw.repository;

import com.claim.ashleyschaefferbmw.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();
    Customer findCustomerByCustomerId(Integer customerId);
}
