package com.example.demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private com.example.demo.dto.DepartmentDTO department;
    private com.example.demo.dto.CompanyDTO company;
    private EmployeeRoleDTO role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public EmployeeRoleDTO getRole() {
        return role;
    }

    public void setRole(EmployeeRoleDTO role) {
        this.role = role;
    }
}
