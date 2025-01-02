package com.example.MySpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
