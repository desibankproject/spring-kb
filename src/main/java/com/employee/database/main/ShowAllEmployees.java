package com.employee.database.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.database.dao.EmployeeEntity;
import com.employee.database.service.EmployeeService;

public class ShowAllEmployees {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("employee-service-dao.xml");
			 EmployeeService employeeService=(EmployeeService)applicationContext.getBean("EmployeServiceImpl");
			 List<EmployeeEntity> employeeEntityList=employeeService.findEmployee();
			 
			 employeeEntityList.forEach((item)-> {
				 System.out.println(item);
			 });
		
		}
}
