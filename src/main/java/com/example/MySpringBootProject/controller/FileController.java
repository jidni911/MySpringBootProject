package com.example.MySpringBootProject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MySpringBootProject.service.ImageDataService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	
	@Autowired
	ImageDataService imageDataService;
	
	@GetMapping("")
	public String upload() {
		return "uploadForm";
	}
	
	@PostMapping("/uploadImage")
	public String imgUpload(@RequestParam("imageFile") MultipartFile imageFile, Model model) {
		if(imageFile.isEmpty()) {
			model.addAttribute("message", "empty");
			return "uploadForm";
		}
		System.out.println(imageFile.getOriginalFilename());
		
		String output =null ;
		try {
			output = imageDataService.uploadImage(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(output.equals(null)) {
			return "uploadForm";
		} else {
			return "uploadSuccess";
		}
	}

}
