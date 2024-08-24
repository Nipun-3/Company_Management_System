package com.example.demo.controller;

import com.example.demo.dto.LocationDTO;
import com.example.demo.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public LocationDTO saveLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.saveLocation(locationDTO);
    }

    @GetMapping("/{id}")
    public LocationDTO getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

//    @GetMapping
//    public List<LocationDTO> getAllLocations() {
//        return locationService.getAllLocations();
//    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}
