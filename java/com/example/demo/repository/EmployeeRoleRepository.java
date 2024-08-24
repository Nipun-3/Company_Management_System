package com.example.demo.repository;

import com.example.demo.entity.EmployeeRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole, Long> {

}
