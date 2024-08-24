package com.example.demo.controller;

import com.example.demo.dto.EmployeeRoleDTO;
import com.example.demo.service.EmployeeRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @PostMapping
    public EmployeeRoleDTO saveEmployeeRole(@RequestBody EmployeeRoleDTO employeeRoleDTO, @RequestParam Long employeeId) {
        return employeeRoleService.saveEmployeeRole(employeeRoleDTO, employeeId);
    }

    @GetMapping("/{id}")
    public EmployeeRoleDTO getEmployeeRoleById(@PathVariable Long id) {
        return employeeRoleService.getEmployeeRoleById(id);
    }

//    @GetMapping
//    public List<EmployeeRoleDTO> getAllEmployeeRoles() {
//        return employeeRoleService.getAllEmployeeRoles();
//    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeRole(@PathVariable Long id) {
        employeeRoleService.deleteEmployeeRole(id);
    }
}
