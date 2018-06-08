package com.mvc.aop.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lakshmi {
 //this is marker annotation
	String value() default "magic";
	String email() default "lakshmi@gmail.com";
}
