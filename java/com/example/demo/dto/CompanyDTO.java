package com.example.demo.dto;

import java.util.Set;

public class CompanyDTO {
    private Long id;
    private String name;
    private IndustriesDTO industry;
    private Set<DepartmentDTO> departments;

    public Set<DepartmentDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentDTO> departments) {
        this.departments = departments;
    }

    public IndustriesDTO getIndustry() {
        return industry;
    }

    public void setIndustry(IndustriesDTO industry) {
        this.industry = industry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
