package com.crm.customer.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private String description;

    @OneToMany (mappedBy = "department")
    List<Employee> employees = new ArrayList<>();
//    private Employee departmentHead;
//    private Date CreatedAt;
//    private String createdBy;


}
