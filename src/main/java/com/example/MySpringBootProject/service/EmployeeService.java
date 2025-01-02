package com.example.MySpringBootProject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MySpringBootProject.entity.Employee;
import com.example.MySpringBootProject.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getAll(){
		return empRepository.findAll();
	}

	public Employee add(Employee employee) {
		return empRepository.save(employee);
		
	}

	public void delete(long id) {
		empRepository.deleteById(id);
		
	}

	public Optional<Employee> getById(Long l) {
		return empRepository.findById(l);
	}

	public List<Employee> search(Long id, String name, LocalDateTime localDateTime, Double salary) {
		// TODO Auto-generated method stub
		
		return empRepository.searchEMP(id,name,localDateTime,salary);
	}
}
