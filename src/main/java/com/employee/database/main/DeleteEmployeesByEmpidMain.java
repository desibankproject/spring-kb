package com.employee.database.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.database.dao.EmployeeEntity;
import com.employee.database.service.EmployeeService;

public class DeleteEmployeesByEmpidMain {
		public static void main(String[] args) {
			
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("employee-service-dao.xml");
			 EmployeeService employeeService=(EmployeeService)applicationContext.getBean("EmployeServiceImpl");
			 List<EmployeeEntity> employeeEntityList=employeeService.findEmployee();
			 employeeEntityList.forEach((item)-> {
				 System.out.println(item);
			 });
			 
			 Scanner scanner=new Scanner(System.in);
			 System.out.println("Enter the employee id please");
			 String empid=scanner.next();
			 String message=employeeService.deleteEmployeeByEmpId(empid);
			 System.out.println(message);
			
			 System.out.println("Remaining record after deleting once employee!");
			  employeeEntityList=employeeService.findEmployee();
			 employeeEntityList.forEach((item)-> {
				 System.out.println(item);
			 });
		
		}
}
