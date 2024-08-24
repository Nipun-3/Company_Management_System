package com.example.demo.dto;

import java.util.Set;

public class IndustriesDTO {
    private Long id;
    private String name;
    private Set<com.example.demo.dto.CompanyDTO> companies;

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

    public Set<CompanyDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDTO> companies) {
        this.companies = companies;
    }
}
