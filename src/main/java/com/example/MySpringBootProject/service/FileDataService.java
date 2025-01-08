package com.example.MySpringBootProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.FileData;
import com.example.MySpringBootProject.repository.FileDataRepository;

@Repository
public class FileDataService {

	@Autowired
	FileDataRepository fileDataRepository;
	
	@Value("${file.path}")
	private String FOLDER_PATH;
	
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
