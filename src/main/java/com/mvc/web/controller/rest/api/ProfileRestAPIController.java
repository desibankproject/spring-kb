package com.mvc.web.controller.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.database.service.EmployeeService;
import com.mvc.web.controller.web.form.EmployeeForm;
import com.mvc.web.controller.web.form.EmployeeList;

@Controller
public class ProfileRestAPIController {
	
	@Autowired
	@Qualifier("EmployeServiceImpl")
	private  EmployeeService employeeService;
	
	
	//This will create new resource
		//http://localhost/spring-kb/jprofiles
		@RequestMapping(value="/jprofiles",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,
					produces={MediaType.APPLICATION_JSON_VALUE})
		@ResponseBody 	public ApplicationMessageResponse  updateProfile(@RequestBody EmployeeForm employeeForm) {
				String status=employeeService.updateEmployee(employeeForm);
				ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
				applicationMessageResponse.setStatus(status);
				applicationMessageResponse.setMessage("profile is update successfully into the data store");
				return applicationMessageResponse;
		}
	
	//This will create new resource
	//http://localhost/spring-kb/jprofiles
	@RequestMapping(value="/jprofiles",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
				produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody 	public ApplicationMessageResponse  uploadProfile(@RequestBody EmployeeForm employeeForm) {
			String status=employeeService.addEmployee(employeeForm);
			ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
			applicationMessageResponse.setStatus(status);
			applicationMessageResponse.setMessage("profile is uploaded successfully into the data store");
			return applicationMessageResponse;
	}
	
	//http://localhost/spring-kb/jprofiles
	@RequestMapping(value="/jprofiles",method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody 	public EmployeeList  prifles(@RequestParam(value="search",
		required=false) String search) {
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
			 EmployeeList employeeList=new EmployeeList();
			 employeeList.setEmployeeForms(employeeEntityList);
			return employeeList;
		}
	
	//http://localhost/spring-kb/jprofiles/E049494
	//@PathVariable is used to read the data from incoming uri
		@RequestMapping(value="/jprofiles/{pempid}",method=RequestMethod.GET,
				produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		@ResponseBody 	public EmployeeForm  findEmployeeByEmpid(@PathVariable(value="pempid") String pempid) {
				EmployeeForm employeeForm=employeeService.findEmployeeByEmpid(pempid);
				return employeeForm;
			}

}
