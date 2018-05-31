package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Dog;

public class DogFoodMainWithSpring {
		public static void main(String[] args) {
			 ApplicationContext applicationContext=new ClassPathXmlApplicationContext("dog-food.xml");
			 Dog dog1=(Dog)applicationContext.getBean("mdog");
			 Dog dog2=(Dog)applicationContext.getBean("sdog");
			 System.out.println(dog1);
			 System.out.println(dog2);
			
		}
}
