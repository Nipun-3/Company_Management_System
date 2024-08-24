package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public CompanyDTO saveCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.saveCompany(companyDTO);
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

//    @GetMapping
//    public List<CompanyDTO> getAllCompanies() {
//        return companyService.getAllCompanies();
//    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}
