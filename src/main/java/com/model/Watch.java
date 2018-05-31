package com.model;

import java.util.Date;

public abstract class Watch {
	private String name;
	public abstract  Date  getDate();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Watch [name=" + name + ", date=" + getDate() + "]";
	}

}
