package com.crm.customer.model;

import com.crm.customer.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String designation;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    LocalDate joiningDate;
    private BigDecimal salary;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany (mappedBy = "manager")
    @JsonIgnore
    private List<Employee> teamMembers;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany (mappedBy = "manager")
    @JsonIgnore
    private List<Project> projectList;

    @ManyToMany
    @JoinTable
            (name="employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
            )
    private Set<Project> projects = new HashSet<>();
}

