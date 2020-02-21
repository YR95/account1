public interface EmployeeDao {
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(String employeeId);
	public Employee findEmployee(String employeeId);
}
