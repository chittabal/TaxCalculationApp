package com.chitta.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitta.rest.entity.Employee;
import com.chitta.rest.repo.IEmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Employee addEmployee(@Valid Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		return empRepo.getEmployeeById(employeeId);
	}

}
