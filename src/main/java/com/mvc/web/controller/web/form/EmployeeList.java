package com.mvc.web.controller.web.form;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeList {
	
	private List<EmployeeForm> employeeForms;

	public List<EmployeeForm> getEmployeeForms() {
		return employeeForms;
	}

	public void setEmployeeForms(List<EmployeeForm> employeeForms) {
		this.employeeForms = employeeForms;
	}

	@Override
	public String toString() {
		return "EmployeeList [employeeForms=" + employeeForms + "]";
	}

}
