package com.model;

public class Frog {

	private String name = "Jacker";
	private String color = "green";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Frog [name=" + name + ", color=" + color + "]";
	}

}
