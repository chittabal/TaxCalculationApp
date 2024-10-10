package com.chitta.rest.service;

import com.chitta.rest.entity.Employee;
import com.chitta.rest.entity.TaxResponse;

public interface ITaxService {

	public TaxResponse calculateTax(Employee employee);

}
