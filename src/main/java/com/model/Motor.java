package com.model;

public class Motor {
	private String name;
	private String color;
	private String model;
	
	public Motor(){
		System.out.println("DC is called");
	}
	public Motor(String name, String color, String model) {
		System.out.println("PC is called");
		this.name = name;
		this.color = color;
		this.model = model;
	}
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Motor [name=" + name + ", color=" + color + ", model=" + model + "]";
	}
	
	
	
}
