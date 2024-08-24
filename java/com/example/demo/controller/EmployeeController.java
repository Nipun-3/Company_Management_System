package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO, @RequestParam Long departmentId, @RequestParam Long companyId, @RequestParam Long roleId) {
        return employeeService.saveEmployee(employeeDTO, departmentId, companyId, roleId);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

//    @GetMapping
//    public List<EmployeeDTO> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
