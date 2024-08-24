package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Location;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO, Long locationId) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location != null) {
            department.setLocation(location);
            Department savedDepartment = departmentRepository.save(department);
            DepartmentDTO resultDTO = new DepartmentDTO();
            BeanUtils.copyProperties(savedDepartment, resultDTO);
            return resultDTO;
        }
        return null; // or throw an exception
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            BeanUtils.copyProperties(department.get(), departmentDTO);
            return departmentDTO;
        }
        return null;
    }

//    @Override
//    public List<DepartmentDTO> getAllDepartments() {
//        return departmentRepository.findAll().stream()
//                .map(department -> {
//                    DepartmentDTO dto = new DepartmentDTO();
//                    BeanUtils.copyProperties(department, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
