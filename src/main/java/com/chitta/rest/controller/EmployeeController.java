package com.chitta.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitta.rest.entity.Employee;
import com.chitta.rest.entity.TaxResponse;
import com.chitta.rest.service.IEmployeeService;
import com.chitta.rest.service.ITaxService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	@Autowired
	private ITaxService taxService;

	@PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(empService.addEmployee(employee), HttpStatus.CREATED);
    }

	@GetMapping(value = "/{employeeId}/tax-deductions")
	public ResponseEntity<TaxResponse> calculateTax(@PathVariable String employeeId) {
		Employee employee = empService.getEmployeeById(employeeId);
		TaxResponse response = taxService.calculateTax(employee);
		return ResponseEntity.ok(response);
	}

}
