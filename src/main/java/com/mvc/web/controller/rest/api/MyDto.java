package com.mvc.web.controller.rest.api;

import org.codehaus.jackson.map.annotate.JsonFilter;

@JsonFilter("myFilter")
public class MyDto {
    private int name;
 
    public MyDto() {
        super();
    }

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyDto [name=" + name + "]";
	}
    
    
 
   
}