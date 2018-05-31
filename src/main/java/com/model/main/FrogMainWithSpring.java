package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Frog;

public class FrogMainWithSpring {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("frog.xml");
			 Frog frog=(Frog)applicationContext.getBean("paa");
			 System.out.println(frog);
		}
}
