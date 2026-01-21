package com.crm.customer.dtos;


import com.crm.customer.enums.EmployeeStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class EmployeeCreateDto {
     private String name;
    private String email;
    private String phone;
    private String designation;
    private EmployeeStatus status;
    LocalDate joiningDate;
    private BigDecimal salary;
    private String username;
    private String password;
}
