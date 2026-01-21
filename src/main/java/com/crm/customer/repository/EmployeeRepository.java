package com.crm.customer.repository;

import com.crm.customer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean existsByEmail(String email);

    Optional<Employee> findByUserUsername(String username);
}
