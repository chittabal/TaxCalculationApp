package com.chitta.rest.service;

import com.chitta.rest.entity.Employee;

import jakarta.validation.Valid;

public interface IEmployeeService {

	public Employee addEmployee(@Valid Employee employee);

	public Employee getEmployeeById(String employeeId);

}
