package com.mvc.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.employee.database.service.EmployeeService;
import com.mvc.web.controller.web.form.EmployeeForm;

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
					EmployeeForm employeeForm=new EmployeeForm();
					employeeForm.setAddress(address);
					employeeForm.setDoe(new Timestamp(new Date().getTime()));
					employeeForm.setEmail(email);
					employeeForm.setEmpid(pempid);
					employeeForm.setGender(gender);
					employeeForm.setName(name);
			 		String status=employeeService.updateEmployee(employeeForm);
			 		System.out.println("response coming from service layer "+status);
		 			model.addAttribute("appstatus","Congratulation! , you have update profile successfully");
		 			//Here hey issue one senRedirect command for given url patten profiles
		 			//Here it is not going to view resolver
		 			return "redirect:/profiles";
					
		}
		
		@GetMapping("/register-employee")
		public String registerEmployeePage() {
					return "register";
		}
	
		@PostMapping("/register-employee")
		public String registerEmployee(MultipartFile file,@RequestParam("empid") String pempid,String name,String email,String gender,String address,Model model) throws IOException {
			
					byte[] images=file.getBytes();
					EmployeeForm employeeForm=new EmployeeForm();
					employeeForm.setPhoto(images);
			 		
					employeeForm.setAddress(address);
					employeeForm.setDoe(new Timestamp(new Date().getTime()));
					employeeForm.setEmail(email);
					employeeForm.setEmpid(pempid);
					employeeForm.setGender(gender);
					employeeForm.setName(name);
			 		String status=employeeService.addEmployee(employeeForm);
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
			List<EmployeeForm> employeeEntityList=employeeService.findEmployee();
			model.addAttribute("employeeEntityList", employeeEntityList);
			return "profiles";
		}
		
	@RequestMapping(value="/jprofiles",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 	public List<EmployeeForm>  prifles(@RequestParam(value="search",required=false) String search) {
			List<EmployeeForm> employeeEntityList=new ArrayList<EmployeeForm>();
			employeeEntityList=employeeService.findEmployee();
			 if(search!=null) {
				 	if(search.equals("Male")) {
				 		//Java8 example with stream + filtering
				 		employeeEntityList=employeeEntityList.stream().filter(item->"Male".equalsIgnoreCase(item.getGender())).collect(Collectors.toList());
				 	}else if(search.equals("Female")) {
				 		employeeEntityList=employeeEntityList.stream().filter(item->"Female".equalsIgnoreCase(item.getGender())).collect(Collectors.toList());
				 	}
			 }
			return employeeEntityList;
		}
		
		@GetMapping("/profiles")
		public String prifles(@RequestParam(value="search",required=false) String search,Model model) {
			List<EmployeeForm> employeeEntityList=new ArrayList<EmployeeForm>();
			employeeEntityList=employeeService.findEmployee();
			 if(search!=null) {
				 	if(search.equals("Male")) {
				 		//Java8 example with stream + filtering
				 		employeeEntityList=employeeEntityList.stream().filter(item->"Male".equalsIgnoreCase(item.getGender())).collect(Collectors.toList());
				 	}else if(search.equals("Female")) {
				 		employeeEntityList=employeeEntityList.stream().filter(item->"Female".equalsIgnoreCase(item.getGender())).collect(Collectors.toList());
				 	}
			 }
			System.out.println(employeeEntityList);
			model.addAttribute("employeeEntityList", employeeEntityList);
			return "profiles";
		}
		
}

