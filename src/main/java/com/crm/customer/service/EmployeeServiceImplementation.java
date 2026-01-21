package com.crm.customer.service;

import com.crm.customer.dtos.EmployeeCreateDto;
import com.crm.customer.model.Employee;
import com.crm.customer.model.User;
import com.crm.customer.repository.EmployeeRepository;
import com.crm.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Employee createEmployee(EmployeeCreateDto employeeDetails) {
        if (employeeRepository.existsByEmail(employeeDetails.getEmail())) {

            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setUsername(employeeDetails.getName());
        user.setPassword(passwordEncoder.encode(employeeDetails.getPassword()));
        user.setRole("Employee");
        userRepository.save(user);

        Employee employee = new Employee();
        employee.setName(employeeDetails.getUsername());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setStatus(employeeDetails.getStatus());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setSalary(employeeDetails.getSalary());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        employee.setUser(user);

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found with id:" +id));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }
}
