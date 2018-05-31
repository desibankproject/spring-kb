package com.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.CustomerEntity;

public class DepatmentServiceMain {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("department-service.xml");
			 DepartmentService departmentService=(DepartmentService)applicationContext.getBean("DepartmentService");
			 departmentService.call();
		}
}
