package com.spring.annotation;

import org.springframework.stereotype.Repository;

@Repository("DepartmentDao")
public class DepartmentDao {
	
	private String name="magicDao";	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void foo() {
		System.out.println("))#)#)#)#foo foo foo_______________");
		System.out.println("))#)#)#)#foo foo foo_______________name  = "+name);
		System.out.println("))#)#)#)#foo foo foo_______________");
	}

}
