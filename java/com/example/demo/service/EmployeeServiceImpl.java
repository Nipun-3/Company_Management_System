package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Company;
import com.example.demo.entity.EmployeeRole;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRoleRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO, Long departmentId, Long companyId, Long roleId) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        Department department = departmentRepository.findById(departmentId).orElse(null);
        Company company = companyRepository.findById(companyId).orElse(null);
        EmployeeRole employeeRole = employeeRoleRepository.findById(roleId).orElse(null);
        if (department != null && company != null && employeeRole != null) {
            employee.setDepartment(department);
            employee.setCompany(company);
            employee.setRole(employeeRole);
            Employee savedEmployee = employeeRepository.save(employee);
            EmployeeDTO resultDTO = new EmployeeDTO();
            BeanUtils.copyProperties(savedEmployee, resultDTO);
            return resultDTO;
        }
        return null; // or throw an exception
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee.get(), employeeDTO);
            return employeeDTO;
        }
        return null;
    }

//    @Override
//    public List<EmployeeDTO> getAllEmployees() {
//        return employeeRepository.findAll().stream()
//                .map(employee -> {
//                    EmployeeDTO dto = new EmployeeDTO();
//                    BeanUtils.copyProperties(employee, dto);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
