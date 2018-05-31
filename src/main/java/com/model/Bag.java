package com.model;

public class Bag {

	private String color;
	private int price;

	public Bag() {

	}

	public Bag(String color, int price) {
		this.color = color;
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bag [color=" + color + ", price=" + price + "]";
	}

}
