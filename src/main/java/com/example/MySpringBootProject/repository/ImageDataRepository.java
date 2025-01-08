package com.example.MySpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.ImageData;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long>{

}
