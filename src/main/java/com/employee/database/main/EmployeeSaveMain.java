package com.employee.database.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.database.dao.EmployeeEntity;
import com.employee.database.service.EmployeeService;import sun.net.www.content.text.plain;

public class EmployeeSaveMain {
		public static void main(String[] args) throws IOException {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("employee-service-dao.xml");
			 EmployeeService employeeService=(EmployeeService)applicationContext.getBean("EmployeServiceImpl");
			 Scanner scanner=new Scanner(System.in);
			 System.out.println("Enter the empid...");
			 String empid=scanner.next();
			 
			 System.out.println("Enter the name...");
			 String name=scanner.next();
			 
			 System.out.println("Enter the email...");
			 String email=scanner.next();
			 
			 System.out.println("Enter the gender...");
			 String gender=scanner.next();
			 
			 System.out.println("Enter the address...");
			 String address=scanner.next();
			 
			 System.out.println("Enter the image path");
			 String imagePath=scanner.next();
			 File fi = new File(imagePath);
			 byte[] photo = Files.readAllBytes(fi.toPath());
			
			 
			 EmployeeEntity employeeEntity=new EmployeeEntity();
			 employeeEntity.setAddress(address);
			 employeeEntity.setDoe(new Timestamp(new Date().getTime()));
			 employeeEntity.setEmail(email);
			 employeeEntity.setEmpid(empid);
			 employeeEntity.setGender(gender);
			 employeeEntity.setName(name);
			 employeeEntity.setPhoto(photo);
			 String status=employeeService.addEmployee(employeeEntity);
			 System.out.println("Hey employee is added into the database successfully!!!!!!!!!!!!!!!!!! with status = "+status);
		}
}
