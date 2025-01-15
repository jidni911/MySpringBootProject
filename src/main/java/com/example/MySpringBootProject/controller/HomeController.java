package com.example.MySpringBootProject.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MySpringBootProject.entity.Employee;
import com.example.MySpringBootProject.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String home(Model model) {
		
//		Employee employee = new Employee();
//		employee.setName("Rakib");
//		employee.setDob(LocalDateTime.now());
//		employee.setEmail("abx@hs.com");
//		employee.setSalary(23.45);
//		employee.setId(1l);
//		empService.delete(2l);
//		System.out.println(empService.getById(5l));
//		System.out.println(empService.getById(1l));
		
		List<Employee> empList = new ArrayList<>();
		empList = empService.getAll();
		model.addAttribute("empList", empList);
		
		return "index";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		empService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model) {
		Employee emp = empService.getById(id).get();
		model.addAttribute("employee", emp);
//		empService.delete(id);
		return "update";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Employee employee) {
		empService.add(employee);
		return "redirect:/";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "create";
	}
	
	@GetMapping("/addrandom")
	public String addRandom(Model model) {
		empService.addRandom();
		return "redirect:/";
	}

	@GetMapping("/search")
	public String search(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String email,
	        @RequestParam(required = false) LocalDateTime localDateTime,
	        @RequestParam(required = false) Double maxSalary,
	        @RequestParam(required = false) Double minSalary,
	        Model model) {
	    
	    // Get all employees from the service
	    List<Employee> empList = empService.search(id,name,email,localDateTime,maxSalary,minSalary);
	    
	    // Apply filters if parameters are provided
		/*
		 * if (id != null) { empList = empList.stream().filter(emp ->
		 * emp.getId().equals(id)).collect(Collectors.toList()); } if (name != null &&
		 * !name.isEmpty()) { empList = empList.stream().filter(emp ->
		 * emp.getName().equalsIgnoreCase(name)).collect(Collectors.toList()); } if
		 * (localDateTime != null) { empList = empList.stream().filter(emp ->
		 * emp.getDob().isEqual(localDateTime)).collect(Collectors.toList()); } if
		 * (salary != null) { empList = empList.stream().filter(emp ->
		 * emp.getSalary().equals(salary)).collect(Collectors.toList()); }
		 */
	    
	    // Add the filtered list to the model
	    model.addAttribute("empList", empList);
	    
	    // Return the view
	    return "index";
	}

	@GetMapping("/error")
	public String getMethodName() {
		return "index";
	}
	

	
}
