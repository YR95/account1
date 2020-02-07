package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDao;
import com.model.Employee;

public class Register {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeDao employee = context.getBean("employeeDaoImpl", EmployeeDao.class);
		employee.createEmployee();
		employee.insertEmployee(new Employee(1,"Dima"));
		System.out.println(employee.getEmployeeById(1).getName());
	}
}
