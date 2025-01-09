
package com.example.MySpringBootProject.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

	public Long uploadImage(MultipartFile file) throws IOException {

//		ImageData data = new ImageData();
//		data.setName(file.getOriginalFilename());
//		data.setType(file.getContentType());
//		data.setImageData(file.getBytes());
//		
//		data = imageDataRepository.save(data);

		ImageData imageData = imageDataRepository.save(ImageData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imageData(file.getBytes()).build());
		if (imageData != null) {
			return imageData.getId();
		}
		return null;
	}

	public byte[] downloadImage(Long id) {
		Optional<ImageData> dbImageData = imageDataRepository.findById(id);
//        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		byte[] images = dbImageData.get().getImageData();
		return images;
	}

	public List<String> downloadAllImage() {
		List<ImageData> all = imageDataRepository.findAll();
//        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		List<String> imagedatas = new ArrayList<>();

		for (int i = 0; i < all.size(); i++) {
			imagedatas.add(Base64.getEncoder().encodeToString(all.get(i).getImageData()));
		}
	
		return imagedatas;
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
