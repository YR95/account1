package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM employee WHERE EmpId=?";
		Employee employee = jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee employee = new Employee(rs.getInt("EmpId"), rs
						.getString("Name"), rs.getInt("Age"));
				return employee;
			}
		});
		return employee;
	}

	@Override
	public void createEmployee() {
		jdbcTemplate.execute("CREATE TABLE employee (EmpId INTEGER, Name CHAR(30), Age INTEGER)");
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "INSERT INTO employee (EmpId, Name, Age) VALUES (?, ?, ?)";
		Object[] params = new Object[] {employee.getId(), employee.getName(), employee.getAge()};
		int[] types = new int[] {Types.INTEGER, Types.VARCHAR, Types.INTEGER};
		return jdbcTemplate.update(sql, params, types);
	}

	@Override
	public int getEmployeeCount() {
		String sql = "SELECT count(*) FROM employee";
		return jdbcTemplate.queryForInt(sql);
	}

	@Override
	public int deleteEmployeeById(int empId) {
		String sql = "DELETE FROM employee WHERE EmpId = ?";
		return jdbcTemplate.update(sql, new Object[] {empId});
	}
}
