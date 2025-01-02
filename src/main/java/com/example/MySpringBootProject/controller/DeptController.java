package com.example.MySpringBootProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dep")
public class DeptController {

	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
}
