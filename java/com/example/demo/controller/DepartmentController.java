package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO, @RequestParam Long locationId) {
        return departmentService.saveDepartment(departmentDTO, locationId);
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

//    @GetMapping
//    public List<DepartmentDTO> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
