package com.mvc.aop.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAdvice {
	
	@Before("@annotation(com.mvc.aop.advice.Lakshmi)")
	public void greetMessage(JoinPoint joinPoint) {
			System.out.println("Lakshmi welcomes for method "+joinPoint.getSignature().getName());
			System.out.println("Passed  Attributes values with annotations are = "+joinPoint.getSignature().getName());
			MethodSignature signature = (MethodSignature)joinPoint.getSignature();
			Method method = signature.getMethod();
			Lakshmi lakshmi = method.getAnnotation(Lakshmi.class);
			System.out.println("value = "+lakshmi.value()+" , email = "+lakshmi.email());
	}

}
