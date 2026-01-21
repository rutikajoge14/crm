package com.crm.customer.service;


import com.crm.customer.dtos.EmployeeCreateDto;
import com.crm.customer.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(EmployeeCreateDto employeeDetails);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);

}
