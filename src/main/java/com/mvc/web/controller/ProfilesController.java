package com.mvc.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.employee.database.dao.EmployeeEntity;
import com.employee.database.service.EmployeeService;

/**
 * 
 * @author VC1
 * 
 *  This is called model since it is annotated with @Controller
 *  @Service , @Respository , @Component
 *  
 */
@Controller
public class ProfilesController {
	
		@Autowired
		@Qualifier("EmployeServiceImpl")
		private  EmployeeService employeeService;
		
		
		
		@PostMapping("/update-employee")
		public String updateEmployee(@RequestParam("empid") String pempid,String name,String email,String gender,String address,Model model) {
			 		EmployeeEntity employeeEntity=new EmployeeEntity();
			 		employeeEntity.setAddress(address);
			 		employeeEntity.setDoe(new Timestamp(new Date().getTime()));
			 		employeeEntity.setEmail(email);
			 		employeeEntity.setEmpid(pempid);
			 		employeeEntity.setGender(gender);
			 		employeeEntity.setName(name);
			 		String status=employeeService.updateEmployee(employeeEntity);
			 		System.out.println("response coming from service layer "+status);
		 			model.addAttribute("appstatus","Congratulation! , you have update profile successfully");
		 			//Here hey issue one senRedirect command for given url patten profiles
		 			//Here it is not going to view resolver
		 			return "redirect:/profiles";
					
		}
	
		@PostMapping("/register-employee")
		public String registerEmployee(MultipartFile file,@RequestParam("empid") String pempid,String name,String email,String gender,String address,Model model) throws IOException {
			
					byte[] images=file.getBytes();
					EmployeeEntity employeeEntity=new EmployeeEntity();
			 		employeeEntity.setPhoto(images);
			 		
			 		employeeEntity.setAddress(address);
			 		employeeEntity.setDoe(new Timestamp(new Date().getTime()));
			 		employeeEntity.setEmail(email);
			 		employeeEntity.setEmpid(pempid);
			 		employeeEntity.setGender(gender);
			 		employeeEntity.setName(name);
			 		String status=employeeService.addEmployee(employeeEntity);
			 		System.out.println("response coming from service layer "+status);
		 			model.addAttribute("appstatus","Congratulation! , you have registered successfully with our application!");
					return "register";
		}
		
		
		@GetMapping("/deleteEmployee")
		public String deleteEmployee(@RequestParam("rowid") String rowid,Model model) {
			String status=employeeService.deleteEmployeeByRowId(rowid);
			if("deleted".equalsIgnoreCase(status)){
				model.addAttribute("appstatus", "Employee with rowid "+rowid+" is deleted from the database!");
			}else{
				model.addAttribute("appstatus", "Sorry , Employee with rowid "+rowid+" is not deleted from the database!");
			}
			// we are fetching all data from database and render whole page again
			List<EmployeeEntity> employeeEntityList=employeeService.findEmployee();
			model.addAttribute("employeeEntityList", employeeEntityList);
			return "profiles";
		}
		
		@GetMapping("/profiles")
		public String prifles(Model model) {
			List<EmployeeEntity> employeeEntityList=employeeService.findEmployee();
			model.addAttribute("employeeEntityList", employeeEntityList);
			return "profiles";
		}
		
}

