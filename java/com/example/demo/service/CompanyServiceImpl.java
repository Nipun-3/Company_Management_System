package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);
        Company savedCompany = companyRepository.save(company);
        CompanyDTO resultDTO = new CompanyDTO();
        BeanUtils.copyProperties(savedCompany, resultDTO);
        return resultDTO;
    }

    @Override
    public CompanyDTO getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            CompanyDTO companyDTO = new CompanyDTO();
            BeanUtils.copyProperties(company.get(), companyDTO);
            return companyDTO;
        }
        return null; // or throw an exception
    }

//    @Override
//    public List<CompanyDTO> getAllCompanies() {
//        return companyRepository.findAll().stream()
//                .map(company -> {
//                    CompanyDTO dto = new CompanyDTO();
//                    BeanUtils.copyProperties(company, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
