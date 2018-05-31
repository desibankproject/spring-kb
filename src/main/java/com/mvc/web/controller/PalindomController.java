package com.mvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author VC1
 * 
 *  This is called model since it is annotated with @Controller
 *  @Service , @Respository , @Component
 *  
 */
@Controller
public class PalindomController {
	
	
	public PalindomController(){
		System.out.println("@#()@@@@@@@@PalindomController@@@@@@@@@@@@@@");
		System.out.println("@#()@@@@@@@@PalindomController@@@@@@@@@@@@@@");
	}
	
	//form action="/check" ,method=GET
	//http://localhost/spring-kb
	@GetMapping("/check")
	public String checkString(HttpServletRequest reqeust){
		String username=reqeust.getParameter("username");
		int j=username.length()-1;
		int flag=0;
		for(int x=0;x<=username.length()/2;x++,j--){
				 if(username.charAt(x)!=username.charAt(j)){
					 flag=1;
					 break;
				 }
		}
		reqeust.setAttribute("appstatus",flag==0?"hey string "+username+" is palindom":"hey string "+username+" is not palindom");
		return "palindrom"; //this the name of JSP where you want to forward the request
		//                    ->>.    /palindrom.jsp
	}
}

