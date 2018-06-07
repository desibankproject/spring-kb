package com.mvc.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//
//<aop:aspectj-autoproxy proxy-target-class="true"/>  
//->
@Aspect  //hey this class is acting as advice ->>> this is the code where we have common functionality
@Component //create a bean of it so that it can work as advice
public class DaoMessageLoggerAdvice {
	
	//Here write common code which you want to inject before every method
	@Before("execution(* com.employee.database.dao.*.*(..))")
	public void messageLogger(JoinPoint joinPoint) {
		System.out.println("Name of the method which is invoked......" + joinPoint.getSignature().getName());
		System.out.println("******>>> Method inputs are - "+Arrays.asList(joinPoint.getArgs()));
		System.out.println("Hey this is method is called at "+new Date());
		System.out.println("_____________________________________________________");
	}

}
