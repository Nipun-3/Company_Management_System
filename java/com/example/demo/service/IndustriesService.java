package com.example.demo.service;

import com.example.demo.dto.IndustriesDTO;

import java.util.List;

public interface IndustriesService {

    IndustriesDTO saveIndustries(IndustriesDTO industriesDTO);

    IndustriesDTO getIndustriesById(Long id);

   // List<IndustriesDTO> getAllIndustries();

    void deleteIndustries(Long id);
}
