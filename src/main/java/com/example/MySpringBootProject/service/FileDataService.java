package com.example.MySpringBootProject.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.MySpringBootProject.entity.FileData;
import com.example.MySpringBootProject.entity.ImageData;
import com.example.MySpringBootProject.repository.FileDataRepository;

@Service
public class FileDataService {

	@Autowired
	FileDataRepository fileDataRepository;
	
	@Value("${file.path}")
	private String FOLDER_PATH;
	

	public Long uploadImage(MultipartFile file) throws IOException {

		long unixTime= System.currentTimeMillis()/1000l;
		
		String filePath = FOLDER_PATH + unixTime +file.getOriginalFilename();
		FileData fileData = fileDataRepository.save(
				FileData.builder()
				.name(unixTime + file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filePath).build());
		
		file.transferTo(new File(filePath));
		
		if (fileData != null) {
			return fileData.getId();
		}
		return null;
	}

	public byte[] downloadImage(Long id) {
	    Optional<FileData> dbImageData = fileDataRepository.findById(id);
	    
	    if (dbImageData.isEmpty()) {
	        throw new RuntimeException("Image not found for the given ID.");
	    }
	    
	    File file = new File( dbImageData.get().getFilePath());
	    
	    try {
	        return Files.readAllBytes(file.toPath());
	    } catch (IOException e) {
	        throw new RuntimeException("Error reading the image file.", e);
	    }
	}


	public List<String> downloadAllImage() {
	    List<FileData> all = fileDataRepository.findAll();

	    // Handle the case where no image data is found
	    if (all.isEmpty()) {
	        throw new RuntimeException("No image data found.");
	    }

	    List<String> imagedatas = new ArrayList<>();
	    
	    for (int i = 0; i < all.size(); i++) {
	        FileData fileData = all.get(i);
	        String base64Image = Base64.getEncoder().encodeToString(downloadImage(fileData.getId()));
	        imagedatas.add(base64Image);
	    }
	    
	    return imagedatas;
	}


	
	public void save(FileData fileData) {
		fileDataRepository.save(fileData);
	}
	public FileData findById(Long id) {
		return fileDataRepository.findById(id).get();
	}
	public List<FileData> findAll() {
		return fileDataRepository.findAll();
	}
	
	public void deleteById(Long id) {
		fileDataRepository.deleteById(id);
	}
}
