package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Bag;
import com.model.BizService;
import com.model.Frog;

public class SingletonBizServiceMainWithSpring {
		public static void main(String[] args) {
			 //if bean is instantiated the moment container is ready!!!!!!!!!!!!
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("singleton-bizservice.xml");
			 System.out.println("Spring container is ready now for the service.......................");
			 BizService bizService1=(BizService)applicationContext.getBean("bizService");
			 System.out.println(bizService1.hashCode());
			 System.out.println("Pulling the service from the spring container!!!!!!!!!!!!!!!!");
			 bizService1.show();
			 
			 BizService bizService2=(BizService)applicationContext.getBean("bizService");
			 System.out.println(bizService2.hashCode());
			 System.out.println("Pulling the service from the spring container!!!!!!!!!!!!!!!!");
		}
}
