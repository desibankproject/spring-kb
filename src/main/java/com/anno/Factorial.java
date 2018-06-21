package com.anno;

/**
 * 
 * @author nagendra
 *
 */
public class Factorial {

	private int num;
	
	public Factorial(){
	}
	
	public Factorial(int num) {
		this.num = num;
	}
	
	/**
	 *  computing factorial of a number
	 * @return int value
	 */
	public int calFact() {
		if(this.num<0){
			RuntimeException exception=new RuntimeException("Hey number cannot be negative to compute fact");
			throw exception;
		}
		int sum=1;
		for(int x=2;x<=num;x++) {
			sum=sum*x;
		}
		return sum;
	}
	
	
	
	
}
