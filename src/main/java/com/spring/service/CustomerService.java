package com.spring.service;

public class CustomerService {
	private String name;
	private String serviceid;
	private CustomerDao customerDao;
	
	public void saveCustomer(CustomerEntity customerEntity){
		System.out.println("Executing the servide layer!!!");
		//code to persist this customer entity into the database!
		customerDao.persist(customerEntity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public String toString() {
		return "CustomerService [name=" + name + ", serviceid=" + serviceid + ", customerDao=" + customerDao + "]";
	}

}
