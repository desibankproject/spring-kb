package com.anno;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author nagendra
 *  this is Junit class for Factorial 
 *
 */
public class FactorialTest {
	
	
	public FactorialTest() {
		 System.out.println("this cons is called for FactorialTest");
	}
	
	
	@Before
	public void againTAgain(){
		System.out.println("Good morning.........................");
	}

	@Test
	public void testCalFactWhenInputZero() {
		   Factorial factorial=new Factorial(0);
		   int fact=factorial.calFact();
		   assertEquals(1, fact);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCalFactWhenInputOne() {
		   Factorial factorial=new Factorial(1);
		   int fact=factorial.calFact();
		   assertEquals(1, fact);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCalFactWhenInputFive() {
		   Factorial factorial=new Factorial(5);
		   int fact=factorial.calFact();
		   assertEquals(120, fact);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCalFactWhenInputSix() {
		  Factorial factorial=new Factorial(6);
		   int fact=factorial.calFact();
		   assertEquals(720, fact);
		//fail("Not yet implemented");
	}

	//This is called negative test .. test case where your actual method is failing
	@Ignore
	@Test(expected=RuntimeException.class)
	public void testCalFactWhenInputNegative() {
		   Factorial factorial=new Factorial(-2);
		   factorial.calFact();
	}

}
