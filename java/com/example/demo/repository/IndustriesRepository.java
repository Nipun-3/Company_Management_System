package com.example.demo.repository;

import com.example.demo.entity.Industries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustriesRepository extends CrudRepository<Industries, Long> {

}
