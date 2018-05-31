package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.HumanLifeCycle;

public class SpringBeanLifeCycleMain {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-bean-life-cycle.xml");
			 HumanLifeCycle humanLifeCycle=(HumanLifeCycle)applicationContext.getBean("magicmagic");
			 System.out.println(humanLifeCycle);
		}
}
