package com.employee.database.dao;

import java.sql.Timestamp;
import java.util.Arrays;

public class EmployeeEntity {

	private int rowid;
	private String empid;
	private String name;
	private String email;
	private String gender;
	private byte[] photo;
	private String address;
	private Timestamp doe;

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [rowid=" + rowid + ", empid=" + empid + ", name=" + name + ", email=" + email
				+ ", gender=" + gender + ", photo=" + Arrays.toString(photo) + ", address=" + address + ", doe=" + doe
				+ "]";
	}

}
