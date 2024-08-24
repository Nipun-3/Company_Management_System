package com.example.demo.controller;

import com.example.demo.dto.IndustriesDTO;
import com.example.demo.service.IndustriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/industries")
public class IndustriesController {

    @Autowired
    private IndustriesService industriesService;

    @PostMapping
    public IndustriesDTO saveIndustries(@RequestBody IndustriesDTO industriesDTO) {
        return industriesService.saveIndustries(industriesDTO);
    }

    @GetMapping("/{id}")
    public IndustriesDTO getIndustriesById(@PathVariable Long id) {
        return industriesService.getIndustriesById(id);
    }

//    @GetMapping
//    public List<IndustriesDTO> getAllIndustries() {
//        return industriesService.getAllIndustries();
//    }

    @DeleteMapping("/{id}")
    public void deleteIndustries(@PathVariable Long id) {
        industriesService.deleteIndustries(id);
    }
}
