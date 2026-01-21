package com.crm.customer.service;

import com.crm.customer.dtos.DepartmentRequestDto;
import com.crm.customer.dtos.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto dto);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto dto);

        void deleteDepartment(Long id);



}

