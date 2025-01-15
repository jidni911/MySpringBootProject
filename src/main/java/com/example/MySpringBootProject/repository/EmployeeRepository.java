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
			+ " (:id is null or e.id = :id) and "
			+ " (:name is null or e.name like '%:name%') and "
			+ " (:email is null or e.email like '%:email%') and "
			+ " (:date is null or e.date_of_birth = :date) and "
			+ " (:maxSalary is null or e.salary <= :maxSalary) and"
			+ " (:minSalary is null or e.salary >= :minSalary)", nativeQuery = true)
	public List<Employee> searchEMP(
			@Param("id") Long id,
			@Param("name") String name,
			@Param("email") String email,
			@Param("date") LocalDateTime localDateTime,
			@Param("maxSalary") Double maxSalary,
			@Param("minSalary") Double minSalary
			);

}
