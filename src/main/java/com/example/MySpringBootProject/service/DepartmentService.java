package com.example.MySpringBootProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MySpringBootProject.entity.Department;
import com.example.MySpringBootProject.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;

	public List<Department> getAll() {
		return deptRepository.findAll();
	}

	public void delete(Long id) {
		deptRepository.deleteById(id);
	}

	public Optional<Department> getById(Long id) {
		return deptRepository.findById(id);
	}

    public void save(Department department) {
        deptRepository.save(department);
    }


}
