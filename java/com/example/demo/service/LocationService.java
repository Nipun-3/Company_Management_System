package com.example.demo.service;

import com.example.demo.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    LocationDTO saveLocation(LocationDTO locationDTO);

    LocationDTO getLocationById(Long id);

   // List<LocationDTO> getAllLocations();

    void deleteLocation(Long id);
}
