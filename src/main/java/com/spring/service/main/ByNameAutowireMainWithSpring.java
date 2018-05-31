package com.spring.service.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.CustomerEntity;
import com.spring.service.CustomerService;

public class ByNameAutowireMainWithSpring {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("by-name-customer-service.xml");
			 CustomerService customerService=(CustomerService)applicationContext.getBean("customerService");
			 CustomerEntity customerEntity=new CustomerEntity();
			 customerEntity.setEmail("ameem@gmail.com");
			 customerEntity.setName("Michal");
			customerEntity.setPhoto("photo.jpg");
			customerService.saveCustomer(customerEntity);
		}
}
