package com.example.MySpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}
