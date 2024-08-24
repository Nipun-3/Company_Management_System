package com.example.demo.service;

import com.example.demo.dto.LocationDTO;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDTO saveLocation(LocationDTO locationDTO) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location);
        Location savedLocation = locationRepository.save(location);
        LocationDTO resultDTO = new LocationDTO();
        BeanUtils.copyProperties(savedLocation, resultDTO);
        return resultDTO;
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            LocationDTO locationDTO = new LocationDTO();
            BeanUtils.copyProperties(location.get(), locationDTO);
            return locationDTO;
        }
        return null;
    }

//    @Override
//    public List<LocationDTO> getAllLocations() {
//        return locationRepository.findAll().stream()
//                .map(location -> {
//                    LocationDTO dto = new LocationDTO();
//                    BeanUtils.copyProperties(location, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
