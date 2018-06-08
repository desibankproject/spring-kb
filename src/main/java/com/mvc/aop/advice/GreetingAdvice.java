package com.mvc.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAdvice {
	
	@Before("@annotation(com.mvc.aop.advice.Lakshmi)")
	public void greetMessage(JoinPoint joinPoint) {
			System.out.println("Lakshmi welcomes for method "+joinPoint.getSignature().getName());
	}

}
