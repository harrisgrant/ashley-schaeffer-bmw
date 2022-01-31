package com.claim.ashleyschaefferbmw.repository;

import com.claim.ashleyschaefferbmw.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();
    Employee findEmployeeByEmployeeId(Integer employeeId);

}
