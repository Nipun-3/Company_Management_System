package com.example.demo.dto;

import java.util.Set;

public class EmployeeRoleDTO {
    private Long id;
    private String role;
    private Set<com.example.demo.dto.EmployeeDTO> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
