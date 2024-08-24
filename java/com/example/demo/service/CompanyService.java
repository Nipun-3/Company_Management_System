package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO saveCompany(CompanyDTO companyDTO);

    CompanyDTO getCompanyById(Long id);

    //List<CompanyDTO> getAllCompanies();

    void deleteCompany(Long id);
}
