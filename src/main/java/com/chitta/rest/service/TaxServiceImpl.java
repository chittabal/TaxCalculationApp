package com.chitta.rest.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.chitta.rest.entity.Employee;
import com.chitta.rest.entity.TaxResponse;

@Service
public class TaxServiceImpl implements ITaxService {

	public TaxResponse calculateTax(Employee employee) {
		double yearlySalary = employee.getSalary();
		LocalDate joiningDate = LocalDate.parse(employee.getDoj());
		LocalDate currentDate = LocalDate.now();

		// Calculate months employed
		Period period = Period.between(joiningDate, currentDate);
		int monthsEmployed = period.getYears() * 12 + period.getMonths();

		// Calculate salary for the months employed
		double salaryForEmployedMonths = (yearlySalary / 12) * monthsEmployed;

		double taxAmount = calculateTaxAmount(salaryForEmployedMonths);
		double cessAmount = calculateCess(salaryForEmployedMonths);

		return new TaxResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary,
				taxAmount, cessAmount);
	}

	private double calculateTaxAmount(double salary) {
		double tax = 0;

		if (salary <= 250000) {
			return 0;
		} else if (salary <= 500000) {
			tax = (salary - 250000) * 0.05;
		} else if (salary <= 1000000) {
			tax = (250000 * 0.05) + (salary - 500000) * 0.10;
		} else {
			tax = (250000 * 0.05) + (500000 * 0.10) + (salary - 1000000) * 0.20;
		}

		return tax;
	}

	private double calculateCess(double salary) {
		if (salary > 2500000) {
			return (salary - 2500000) * 0.02;
		}
		return 0;
	}

}
