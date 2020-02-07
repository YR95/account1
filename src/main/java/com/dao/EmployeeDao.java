package com.dao;

import com.model.Employee;

public interface EmployeeDao {
	Employee getEmployeeById(int id);

	void createEmployee();

	int insertEmployee(Employee employee);

	int deleteEmployeeById(int empId);

	int getEmployeeCount();
}
