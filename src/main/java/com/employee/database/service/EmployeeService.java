package com.employee.database.service;

import java.util.List;

import com.mvc.web.controller.web.form.EmployeeForm;

public interface EmployeeService {

	public String addEmployee(EmployeeForm employeeEntity);

	public List<EmployeeForm> findEmployee();

	public String deleteEmployeeByEmpId(String empid);

	public String authUser(String username, String password);

	public String deleteEmployeeByRowId(String rowid);

	public String updateEmployee(EmployeeForm employeeForm);

	public byte[] findImageRowid(int rowid);

}
