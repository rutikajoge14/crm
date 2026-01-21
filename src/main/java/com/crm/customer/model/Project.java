package com.crm.customer.model;

import com.crm.customer.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToMany (mappedBy = "projects")
    @JsonIgnore
    private Set<Employee> teamMembers = new HashSet<>();
}
