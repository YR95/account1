package com.main;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Employee;

public class Register {
	public static void main(String[] args) {
		EmployeeDao employee = new EmployeeDaoImpl();
		employee.createEmployee();
		employee.insertEmployee(new Employee(1,"Dima"));
		System.out.println(employee.getEmployeeById(1).getName());
	}
}
