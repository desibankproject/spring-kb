package com.model.main;

import java.util.Scanner;

import com.model.Bag;

public class BagMain {

		public static void main(String[] args) {
			
			Scanner scanner=new  Scanner(System.in);
			System.out.println("Enter the name");
			String name=scanner.next();
			
			System.out.println("Enter the price");
			int price=scanner.nextInt();
			
			Bag bag=new Bag(name, price);
			System.out.println(bag);
		
		}
}
