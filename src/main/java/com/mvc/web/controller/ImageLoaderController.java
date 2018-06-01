package com.mvc.web.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.database.service.EmployeeService;

@Controller
public class ImageLoaderController {
	
	
	@Autowired
	@Qualifier("EmployeServiceImpl")
	private  EmployeeService employeeService;
	
	//http://localhost/spring-kb/load-image?imageid=13
	@GetMapping("/load-image")
	public void loadImage(@RequestParam("imageid") int rowid,HttpServletResponse response) throws IOException{
		//I want to send image as response
		response.setContentType("image/png");
		byte[] image=employeeService.findImageRowid(rowid);
		ServletOutputStream  sos=response.getOutputStream();
		sos.write(image);
		sos.flush();
		sos.close();
	}

}
