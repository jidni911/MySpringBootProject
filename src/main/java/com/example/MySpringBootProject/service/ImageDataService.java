
package com.example.MySpringBootProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.MySpringBootProject.entity.ImageData;
import com.example.MySpringBootProject.repository.ImageDataRepository;

@Service
public class ImageDataService {
	@Autowired
	ImageDataRepository imageDataRepository;

	@Value("${file.path}")
	private String FOLDER_PATH;

	public String uploadImage(MultipartFile file) throws IOException {
		
//		ImageData data = new ImageData();
//		data.setName(file.getOriginalFilename());
//		data.setType(file.getContentType());
//		data.setImageData(file.getBytes());
//		
//		data = imageDataRepository.save(data);
		
		ImageData imageData = imageDataRepository.save(
				ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(file.getBytes()).build()
				);
		if(imageData!=null) {
			return "Successfull";
		}
		return null;
	}

	public void save(ImageData imageData) {
		imageDataRepository.save(imageData);
	}

	public ImageData findById(Long id) {
		return imageDataRepository.findById(id).get();
	}

	public List<ImageData> findAll() {
		return imageDataRepository.findAll();
	}

	public void deleteById(Long id) {
		imageDataRepository.deleteById(id);
	}
}
