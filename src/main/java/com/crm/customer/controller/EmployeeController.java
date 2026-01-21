package com.crm.customer.controller;

import com.crm.customer.dtos.EmployeeCreateDto;
import com.crm.customer.model.Employee;
import com.crm.customer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee>
    createEmployee(@RequestBody EmployeeCreateDto dto ){
        Employee employee = employeeService.createEmployee(dto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/admin/employees/{id}")
    public void delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }


}
