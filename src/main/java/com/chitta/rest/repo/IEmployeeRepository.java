package com.chitta.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chitta.rest.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("from Employee where employeeId=:employeeId")
	Employee getEmployeeById(String employeeId);

}
