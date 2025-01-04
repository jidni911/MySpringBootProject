package com.example.MySpringBootProject.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

	public List<Employee> search(Long id, String name,String email, LocalDateTime localDateTime, Double maxSalary, Double minSalary) {
		
		return empRepository.searchEMP(id,name,email,localDateTime,maxSalary,minSalary);
	}

	public static Employee generateRandomEmployee() {
        Random random = new Random();
        Employee employee = new Employee();
        
        // Generate random name
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sophia", "Chris", "Laura"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Davis", "Brown", "Wilson", "Clark", "Taylor"};
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        employee.setName(firstName + " " + lastName);

        // Generate random email
        String emailDomain = "@example.com";
        employee.setEmail(firstName.toLowerCase() + lastName.toLowerCase() + random.nextInt(100) + emailDomain);

        // Generate random date of birth (between 1980-01-01 and 2000-12-31)
        int year = 1980 + random.nextInt(21); // 1980 to 2000
        Month month = Month.of(1 + random.nextInt(12)); // January to December
        int day = 1 + random.nextInt(month.length(false)); // Day of month
        employee.setDob(LocalDateTime.of(year, month, day, 0, 0));

        // Generate random salary (40,000 to 100,000)
        double salary = 40000 + (random.nextDouble() * 60000);
        employee.setSalary(Math.round(salary * 100.0) / 100.0); // Round to 2 decimal places

        return employee;
    }

	public Employee addRandom() {
		Employee employee = generateRandomEmployee();
		return empRepository.save(employee);
	}
}
