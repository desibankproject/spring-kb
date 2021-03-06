package com.employee.database.dao;

import java.util.List;

import com.employee.database.dao.entity.EmployeeEntity;

public interface EmployeeDao {

	public String addEmployee(EmployeeEntity employeeEntity);

	public List<EmployeeEntity> findEmployee();

	public String deleteEmployeeByEmpId(String empid);

	public String authUser(String username, String password);

	public String deleteEmployeeByRowId(String rowid);

	 public String updateEmployee(EmployeeEntity employeeEntity);

	 public byte[] findImageRowid(int rowid);

	 default public List<EmployeeEntity> findEmployee(int offeset) {
		 return null;
	 }
	 
	 default public EmployeeEntity findEmployeeByEmpid(String empid) {
		 return null;
	 }

}
