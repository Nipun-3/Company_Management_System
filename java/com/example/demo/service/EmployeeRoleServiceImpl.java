package com.example.demo.service;

import com.example.demo.dto.EmployeeRoleDTO;
import com.example.demo.entity.EmployeeRole;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRoleRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeRoleDTO saveEmployeeRole(EmployeeRoleDTO employeeRoleDTO, Long employeeId) {
        EmployeeRole employeeRole = new EmployeeRole();
        BeanUtils.copyProperties(employeeRoleDTO, employeeRole);

        // Fetch employee by ID
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            // Convert single Employee to Set<Employee>
            Set<Employee> employeeSet = new HashSet<>();
            employeeSet.add(employee);
            // Set employee in employeeRole
            employeeRole.setEmployees(employeeSet);

            EmployeeRole savedEmployeeRole = employeeRoleRepository.save(employeeRole);

            // Map saved entity to DTO
            EmployeeRoleDTO resultDTO = new EmployeeRoleDTO();
            BeanUtils.copyProperties(savedEmployeeRole, resultDTO);
            return resultDTO;
        }
        return null; // or throw an exception
    }

    @Override
    public EmployeeRoleDTO getEmployeeRoleById(Long id) {
        Optional<EmployeeRole> employeeRole = employeeRoleRepository.findById(id);
        if (employeeRole.isPresent()) {
            EmployeeRoleDTO employeeRoleDTO = new EmployeeRoleDTO();
            BeanUtils.copyProperties(employeeRole.get(), employeeRoleDTO);
            return employeeRoleDTO;
        }
        return null;
    }

//    @Override
//    public List<EmployeeRoleDTO> getAllEmployeeRoles() {
//        return employeeRoleRepository.findAll().stream()
//                .map(employeeRole -> {
//                    EmployeeRoleDTO dto = new EmployeeRoleDTO();
//                    BeanUtils.copyProperties(employeeRole, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteEmployeeRole(Long id) {
        employeeRoleRepository.deleteById(id);
    }
}
