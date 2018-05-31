package com.employee.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.database.dao.EmployeeDao;
import com.employee.database.dao.EmployeeEntity;

@Service("EmployeServiceImpl")
public class EmployeServiceImpl  implements EmployeeService{
	
	@Autowired
	@Qualifier("EmployeeDaoImpl")
	private EmployeeDao employeeDao;
	
	@Override
	public String authUser(String username,String password){
		return employeeDao.authUser(username, password);
	}
	
	@Override
	public String addEmployee(EmployeeEntity employeeEntity){
		System.out.println("Service layer addEmployee method is called!");
		String result=employeeDao.addEmployee(employeeEntity);
		return result;
	}
	
	@Override
	public List<EmployeeEntity> findEmployee(){
		return employeeDao.findEmployee();
	}
	
	@Override
	public String deleteEmployeeByEmpId(String empid){
		return employeeDao.deleteEmployeeByEmpId(empid);
	}
	@Override
	public String deleteEmployeeByRowId(String rowid){
		return employeeDao.deleteEmployeeByRowId(rowid);
	}
	


}
