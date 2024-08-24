package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO, Long departmentId, Long companyId, Long roleId);

    EmployeeDTO getEmployeeById(Long id);

  //  List<EmployeeDTO> getAllEmployees();

    void deleteEmployee(Long id);
}
