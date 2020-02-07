package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public Employee getEmployeeById(int id) {
		Connection connection = null;
		Employee employee = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(id, rs.getString("name"));
			}
			rs.close();
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				}
				catch (SQLException e) {
				}
			}
		}
		return employee;
	}

	@Override
	public void createEmployee() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE employee (id INTEGER, name CHAR(30))");
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void insertEmployee(Employee employee) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into employee values ("
					+ employee.getId() + ",'" +
					employee.getName() + "')");
			stmt.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
				}
			}
		}
	}
}
