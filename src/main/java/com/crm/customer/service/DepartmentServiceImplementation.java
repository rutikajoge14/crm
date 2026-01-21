package com.crm.customer.service;

import com.crm.customer.dtos.DepartmentRequestDto;
import com.crm.customer.dtos.DepartmentResponseDto;
import com.crm.customer.model.Department;
import com.crm.customer.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        Department savedDepartment = departmentRepository.save(department);

        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setId(savedDepartment.getId());
        departmentResponseDto.setName(savedDepartment.getName());
        departmentResponseDto.setDescription(savedDepartment.getDescription());
        return departmentResponseDto;
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        List<Department> departments= departmentRepository.findAll();
        List<DepartmentResponseDto> responseDtoList = new ArrayList<>();

        for (Department department :departments){
            DepartmentResponseDto dto = new DepartmentResponseDto();
            dto.setId(department.getId());
            dto.setName(department.getName());
            dto.setDescription(department.getDescription());

            responseDtoList.add(dto);

        }
        return responseDtoList;
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto dto) {

       Department department = departmentRepository.findById(id).orElseThrow(()->
               new RuntimeException("Department not found with id: " +id));
       department.setName(dto.getName());
       department.setDescription(dto.getDescription());

       Department updated = departmentRepository.save(department);

       DepartmentResponseDto response = new DepartmentResponseDto();
       response.setId(updated.getId());
       response.setName(updated.getName());
       response.setDescription(updated.getDescription());

        return response;
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Department not found with id:" +id));

        departmentRepository.delete(department);


    }
}
