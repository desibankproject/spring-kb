package com.model;

import org.springframework.beans.factory.BeanNameAware;

//We have concept of  Aware interface in spring
//Aware interface injects some special feature inside the bean during it's life cycle!!!!!!!
public class HumanLifeCycle implements BeanNameAware  {

	private String beanName;
	private int age;
	private String name;
	
	
	public void initialize(){
		System.out.println("@)@)@))initialize is called!!!!!!!!!!!!!!!@)@");
	}

	public HumanLifeCycle() {
		System.out.println("HumanLifeCycle DC is called");
	}

	public HumanLifeCycle(int age, String name) {
		System.out.println("HumanLifeCycle PC is called");
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Setting the age");
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting the name");
		this.name = name;
	}

	public void setBeanName(String arg0) {
		System.out.println(")#)#)#)AWARE Interface is called!#)");
		this.beanName=arg0;
	}

	@Override
	public String toString() {
		return "HumanLifeCycle [beanName=" + beanName + ", age=" + age + ", name=" + name + "]";
	}

}
