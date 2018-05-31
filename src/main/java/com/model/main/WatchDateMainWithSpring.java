package com.model.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Dog;
import com.model.Watch;

public class WatchDateMainWithSpring {
	public static void main(String[] args) throws InterruptedException {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("watch-date.xml");
		Watch watch = (Watch) applicationContext.getBean("watch");
		System.out.println(watch);
		System.out.println(watch.hashCode());
		Thread.sleep(5000);

		watch = (Watch) applicationContext.getBean("watch");
		System.out.println(watch.hashCode());
		System.out.println(watch);
		Thread.sleep(5000);

		watch = (Watch) applicationContext.getBean("watch");
		System.out.println(watch.hashCode());
		System.out.println(watch);
		Thread.sleep(5000);

		watch = (Watch) applicationContext.getBean("watch");
		System.out.println(watch.hashCode());
		System.out.println(watch);
		Thread.sleep(5000);

	}
}
