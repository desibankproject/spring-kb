package com.mvc.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 
 *
 */
@Aspect
@Service
public class FinisherAdvice {
		//Here write common code which you want to inject before every method
		@After("execution(* com.employee.database.dao.*.*(..))")
		public void messageLogger(JoinPoint joinPoint) {
			System.out.println("******>>> Method inputs are - "+Arrays.asList(joinPoint.getArgs()));
			System.out.println(joinPoint.getSignature().getName()+"with....."+Arrays.asList(joinPoint.getArgs())+" execution is finised at "+new Date());
		}

}
