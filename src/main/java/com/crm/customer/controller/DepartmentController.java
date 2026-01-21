package com.crm.customer.controller;

import com.crm.customer.dtos.DepartmentRequestDto;
import com.crm.customer.dtos.DepartmentResponseDto;
import com.crm.customer.model.Department;
import com.crm.customer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    public DepartmentService service;

    @PostMapping("/admin/departments")
    public DepartmentResponseDto createDepartment(@RequestBody DepartmentRequestDto department){
        return service.createDepartment(department);
    }

    @GetMapping("/hr/departments")
    public List<DepartmentResponseDto> getDepartments(){
        return service.getAllDepartments();
    }

    @PutMapping("/admin/departments/{id}")
    public DepartmentResponseDto updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentRequestDto dto) {

        return service.updateDepartment(id, dto);
    }

    @DeleteMapping("/admin/departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
        return "Department deleted successfully";
    }

}
