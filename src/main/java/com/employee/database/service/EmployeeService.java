package com.employee.database.service;

import java.util.List;

import com.employee.database.dao.EmployeeEntity;

public interface EmployeeService {

	public String addEmployee(EmployeeEntity employeeEntity);

	public List<EmployeeEntity> findEmployee();

	public String deleteEmployeeByEmpId(String empid);

	public String authUser(String username, String password);

	public String deleteEmployeeByRowId(String rowid);

}
