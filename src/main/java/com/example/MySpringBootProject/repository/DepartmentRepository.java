package com.example.MySpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "select * from dept where id = :id or name = :name ",nativeQuery = true)
    public List<Department> searchDep(
        @Param("id") Long id,
        @Param("name") String name
    );
}
