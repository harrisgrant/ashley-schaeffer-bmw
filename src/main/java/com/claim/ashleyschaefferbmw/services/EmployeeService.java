package com.claim.ashleyschaefferbmw.services;

import com.claim.ashleyschaefferbmw.entity.Employee;
import com.claim.ashleyschaefferbmw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee findEmployeeByEmployeeId(Integer employeeId) {
        return employeeRepository.findEmployeeByEmployeeId(employeeId);
    }


    public Employee addEmployee(Employee employee) {
        Employee addEmployee = new Employee(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName());
        return employeeRepository.save(addEmployee);
    }


    public Employee updateEmployee(Employee employee, Integer employeeId) {
        Employee updateEmployee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if (employee == null) { return null; }
        employee.setEmployeeId(employee.getEmployeeId());
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        return employeeRepository.save(updateEmployee);
    }


    public Boolean deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if (employee != null) { employeeRepository.delete(employee); }
        return true;
    }
}

