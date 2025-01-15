package com.example.MySpringBootProject.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MySpringBootProject.service.FileDataService;
import com.example.MySpringBootProject.service.ImageDataService;

@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	FileDataService imageDataService;

	@GetMapping("")
	public String upload() {
		return "uploadForm";
	}

	@PostMapping("/uploadImage")
	public String imgUpload(@RequestParam("imageFile") MultipartFile imageFile, Model model) {
		if (imageFile.isEmpty()) {
			model.addAttribute("message", "empty");
			return "uploadForm";
		}
//		System.out.println(imageFile.getOriginalFilename());

		Long output = null;
		try {
			output = imageDataService.uploadImage(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!output.equals(null)) {

			byte[] imageBytes = imageDataService.downloadImage(output);

			String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
			
			model.addAttribute("image", encodedImage);

			return "uploadSuccess";
		}
		return "uploadForm";
	}
	
	@GetMapping("/getAllImages")
	public String getMethodName(Model model) {
		List<String> images = imageDataService.downloadAllImage();
		model.addAttribute("images", images);
		return "uploadSuccess";
	}
	

}
