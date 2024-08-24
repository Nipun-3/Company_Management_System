package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO, Long locationId);

    DepartmentDTO getDepartmentById(Long id);

   // List<DepartmentDTO> getAllDepartments();

    void deleteDepartment(Long id);
}
