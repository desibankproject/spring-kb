package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Bag;
import com.model.Frog;
import com.model.Motor;

public class MotorMainWithSpring {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("motor.xml");
			 Motor motor=(Motor)applicationContext.getBean("motor");
			 System.out.println(motor);
		}
}
