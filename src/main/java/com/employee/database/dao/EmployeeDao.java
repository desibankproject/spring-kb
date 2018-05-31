package com.employee.database.dao;

import java.util.List;

public interface EmployeeDao {

	public String addEmployee(EmployeeEntity employeeEntity);

	public List<EmployeeEntity> findEmployee();

	public String deleteEmployeeByEmpId(String empid);

	public String authUser(String username, String password);

	public String deleteEmployeeByRowId(String rowid);

}
