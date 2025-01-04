package com.example.MySpringBootProject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MySpringBootProject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from emp e where"
			+ " e.id = :id or "
			+ " e.name = :name or "
			+ " e.date_of_birth = :date or "
			+ " e.salary = :salary ", nativeQuery = true)
	public List<Employee> searchEMP(
			@Param("id") Long id,
			@Param("name") String name,
			@Param("date") LocalDateTime localDateTime,
			@Param("salary") Double salary
			);

}
