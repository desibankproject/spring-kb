package com.employee.database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.database.dao.EmployeeDao;
import com.employee.database.dao.EmployeeEntity;
import com.mvc.aop.advice.Lakshmi;
import com.mvc.web.controller.web.form.EmployeeForm;

@Service("EmployeServiceImpl")
public class EmployeServiceImpl  implements EmployeeService{
	
	@Autowired
	@Qualifier("EmployeeDaoImpl")
	private EmployeeDao employeeDao;
	
	@Override
	@Lakshmi
	 public byte[] findImageRowid(int rowid){
		return employeeDao.findImageRowid( rowid);
	 }
	
	@Override
	public String authUser(String username,String password){
		return employeeDao.authUser(username, password);
	}
	
	@Override
	public String updateEmployee(EmployeeForm employeeForm) {
		System.out.println("Service layer updateEmployee method is called!");
		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeForm, employeeEntity);
		String result=employeeDao.updateEmployee(employeeEntity);
		return result;
	}
	
	@Override
	public String addEmployee(EmployeeForm employeeForm){
		System.out.println("Service layer addEmployee method is called!");
		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeForm, employeeEntity);
		String result=employeeDao.addEmployee(employeeEntity);
		return result;
	}
	
	@Override
	public List<EmployeeForm> findEmployee() {
		List<EmployeeForm> employeeForms=new ArrayList<EmployeeForm>();
		List<EmployeeEntity> employeeEntitityList=employeeDao.findEmployee();
		employeeEntitityList.forEach(entity->{
			EmployeeForm employeeForm=new EmployeeForm();
			BeanUtils.copyProperties(entity, employeeForm);
			employeeForms.add(employeeForm);
		});
		return employeeForms;
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
