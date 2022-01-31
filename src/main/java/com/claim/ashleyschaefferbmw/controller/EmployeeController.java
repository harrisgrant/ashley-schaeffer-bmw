package com.claim.ashleyschaefferbmw.controller;

import com.claim.ashleyschaefferbmw.entity.Employee;
import com.claim.ashleyschaefferbmw.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeByEmployeeId(@PathVariable Integer employeeId) {
        return employeeService.findEmployeeByEmployeeId(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping( "/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer employeeId) {
        return employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Boolean deleteEmployee(@PathVariable Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}

