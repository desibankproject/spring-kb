package com.mvc.web.controller.rest.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyFilter;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mvc.web.controller.rest.api.exception.EmployeeDoesNotExistException;
import com.mvc.web.controller.rest.api.util.AppRestConstant;
import com.mvc.web.controller.web.form.EmployeeForm;
import com.mvc.web.controller.web.form.EmployeeList;
import com.mvc.web.controller.web.form.EmployeeSerializer;

@Controller
@RequestMapping(AppRestConstant.REST_V3_API)
public class ProfileRestAPIController {
	
	@Autowired
	@Qualifier("EmployeServiceImpl")
	private  EmployeeService employeeService;
	
	
	//This will create new resource
		//http://localhost/spring-kb/v3/jprofiles
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
	@ResponseBody 	public ApplicationMessageResponse  uploadProfile(@RequestBody EmployeeForm employeeForm) throws JsonGenerationException, JsonMappingException, IOException {
			String status=employeeService.addEmployee(employeeForm);
			//Convert object to JSON string
			/*ObjectMapper mapper = new ObjectMapper();
			 FilterProvider filters = new SimpleFilterProvider()
		             .addFilter("filter properties by field names",
		                 SimpleBeanPropertyFilter.serializeAllExcept(new String[]{"name"}));
		       ObjectWriter writer = mapper.writer().withFilters(filters);
		       String jsonInStringText=writer.writeValueAsString(employeeForm);
		       System.out.println(jsonInStringText);*/
			 Gson gson = new GsonBuilder().create();
			 gson = new GsonBuilder()
		                .registerTypeAdapter(EmployeeForm.class, new EmployeeSerializer())
		                .create();
			 String jsonData = gson.toJson(employeeForm);
			 System.out.println(jsonData);
			 
			 System.out.println(employeeForm);
			 BeanPropertyFilter theFilter = new SimpleBeanPropertyFilter() {
				@Override
				public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider,
						BeanPropertyWriter writer) throws Exception {
					// TODO Auto-generated method stub
						System.out.println("output = "+writer.getName());	
				         if (!writer.getName().equals("name")) {
				            writer.serializeAsField(pojo, jgen, provider);
				            return;
				         }
				        
					}
				};
				FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
				ObjectMapper mapper = new ObjectMapper();
				String dtoAsString = mapper.writer(filters).writeValueAsString(employeeForm);
				 System.out.println(dtoAsString);
			
			ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
			applicationMessageResponse.setStatus(status);
			applicationMessageResponse.setUri("http://localhost/spring-kb/jprofiles");
			applicationMessageResponse.setMessage("profile is uploaded successfully into the data store");
			return applicationMessageResponse;
	}
	
	//http://localhost/spring-kb/jprofiles
	@RequestMapping(value="/jprofiles",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
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
				if(employeeForm.getEmpid()==null){
					EmployeeDoesNotExistException exception=new EmployeeDoesNotExistException("Hey this empid "+pempid+" does not exist into out database!");
					throw exception;
				}
				return employeeForm;
			}

}
