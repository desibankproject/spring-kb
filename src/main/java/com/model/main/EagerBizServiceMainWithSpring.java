package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Bag;
import com.model.BizService;
import com.model.Frog;

public class EagerBizServiceMainWithSpring {
		public static void main(String[] args) {
			 //if bean is instantiated the moment container is ready!!!!!!!!!!!!
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("eager-bizservice.xml");
			 System.out.println("Spring container is ready now for the service.......................");
			 BizService bizService=(BizService)applicationContext.getBean("bizService");
			 System.out.println("Pulling the service from the spring container!!!!!!!!!!!!!!!!");
			 bizService.show();
		}
}
