package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Bag;
import com.model.Frog;

public class BagMainWithSpring {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bag.xml");
			 Bag bag=(Bag)applicationContext.getBean("bag");
			 System.out.println(bag);
		}
}
