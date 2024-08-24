package com.example.demo.service;

import com.example.demo.dto.IndustriesDTO;
import com.example.demo.entity.Industries;
import com.example.demo.repository.IndustriesRepository;
import com.example.demo.service.IndustriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndustriesServiceImpl implements IndustriesService {

    @Autowired
    private IndustriesRepository industriesRepository;

    @Override
    public IndustriesDTO saveIndustries(IndustriesDTO industriesDTO) {
        Industries industries = new Industries();
        BeanUtils.copyProperties(industriesDTO, industries);
        Industries savedIndustries = industriesRepository.save(industries);
        IndustriesDTO resultDTO = new IndustriesDTO();
        BeanUtils.copyProperties(savedIndustries, resultDTO);
        return resultDTO;
    }

    @Override
    public IndustriesDTO getIndustriesById(Long id) {
        Optional<Industries> industries = industriesRepository.findById(id);
        if (industries.isPresent()) {
            IndustriesDTO industriesDTO = new IndustriesDTO();
            BeanUtils.copyProperties(industries.get(), industriesDTO);
            return industriesDTO;
        }
        return null;
    }

//    @Override
//    public List<IndustriesDTO> getAllIndustries() {
//        return industriesRepository.findAll().stream()
//                .map(industries -> {
//                    IndustriesDTO dto = new IndustriesDTO();
//                    BeanUtils.copyProperties(industries, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteIndustries(Long id) {
        industriesRepository.deleteById(id);
    }
}
