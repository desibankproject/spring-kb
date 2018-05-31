package com.model.main;

import com.model.Frog;

public class FrogMain {

		public static void main(String[] args) {
			//who is creating object of the class ? programmer
			Frog frog=new Frog();
			////who is calling this method ? programmer
			String result=frog.toString(); //
			System.out.println(result);
		}
}
