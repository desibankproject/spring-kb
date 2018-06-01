package com.mvc.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.database.dao.EmployeeEntity;
import com.employee.database.service.EmployeeService;

/**
 * 
 * @author VC1
 * 
 *  This is called model since it is annotated with @Controller
 *  @Service , @Respository , @Component
 *  
 */
@Controller
public class AuthController {
	//<listener>
	//<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>	
   //</listener>
	@Autowired
	@Qualifier("EmployeServiceImpl")
	private  EmployeeService employeeService;
	
	
	
	public	AuthController(){
		//	 <context-param>
 		///<param-name>contextConfigLocation</param-name>
 		//<param-value>classpath:employee-service-dao.xml</param-value>
			///</context-param>
		//<listener>
		//<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>	
	   //</listener>
		//below is not right approach!!!!!!!!!!
		/* ApplicationContext applicationContext=new ClassPathXmlApplicationContext("employee-service-dao.xml");
		 EmployeeService employeeService=(EmployeeService)applicationContext.getBean("EmployeServiceImpl");*/
	}
	
	//@PostMapping("/auth")
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String checkString(String username,String password,Model model) {
		 String status=employeeService.authUser(username, password);
				if("pass".equalsIgnoreCase(status)){
					model.addAttribute("appstatus","Username and password are correct!!!!!!!!!!!!!!!!!!!!!");
					return "home";
				}else{
					model.addAttribute("appstatus","Sorry! , Username and password are not correct!!!!!!!!!!!!!!!!!!!!!");
					return "login";
				}
	}
	
}

