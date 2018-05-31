package com.spring.service;

public class CustomerDao {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void persist(CustomerEntity customerEntity){
		System.out.println(")#)#persist start#)#)#) name = "+name);
		System.out.println(customerEntity);
		System.out.println(")#)#end#)#)#)");
	}

}
