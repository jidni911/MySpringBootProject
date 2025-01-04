package com.example.MySpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MySpringBootProject.entity.Department;
import com.example.MySpringBootProject.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("")
	public String home(Model model) {
		List<Department> allDept = departmentService.getAll();
		model.addAttribute("departments", allDept);
		return "deptIndex";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		departmentService.delete(id);
		return "redirect:/dept";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model) {
		Department department = departmentService.getById(id).get();
		model.addAttribute("department", department);
		return "updateDept";
	}

	@PostMapping("/save")
	public String confirmEdit(@ModelAttribute Department department) {
		departmentService.save(department);
		return "redirect:/dept";
	}
	@GetMapping("add")
	public String add() {
		return "addDept";
	}
	
	
	
}
