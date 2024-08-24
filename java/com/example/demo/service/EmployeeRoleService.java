package com.example.demo.service;

import com.example.demo.dto.EmployeeRoleDTO;

import java.util.List;

public interface EmployeeRoleService {

    EmployeeRoleDTO saveEmployeeRole(EmployeeRoleDTO employeeRoleDTO, Long employeeId);

    EmployeeRoleDTO getEmployeeRoleById(Long id);

    //List<EmployeeRoleDTO> getAllEmployeeRoles();

    void deleteEmployeeRole(Long id);
}
