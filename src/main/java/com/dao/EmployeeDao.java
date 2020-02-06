package com.dao;

import com.model.Employee;

public interface  EmployeeDao {
	Employee getEmployeeById(int id);

	void createEmployee();

	void insertEmployee(Employee employee);
}
