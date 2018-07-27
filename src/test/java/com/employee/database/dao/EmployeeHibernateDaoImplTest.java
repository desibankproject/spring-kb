/*package com.employee.database.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.employee.database.dao.entity.EmployeeEntity;


@RunWith(SpringJUnit4ClassRunner.class) //We are using spring junit runner so that we can utilize features of spring inside the test cases
//below will create spring container which will manage all the beans involves in dao layers
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:test-employee-dao.xml" })
@Rollback
@Transactional(transactionManager="transactionManager")
public class EmployeeHibernateDaoImplTest {

	@Autowired
	@Qualifier("EmployeeHibernateDaoImpl")
	private EmployeeDao hibernateEmployeeDao;
	
	@Test
	public void testAddEmployee() {
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setAddress("CA10,Fremont");
		employeeEntity.setEmail("simon@gmail.com");
		employeeEntity.setEmpid("E9990");
		employeeEntity.setGender("Male");
		employeeEntity.setName("Simon");
		employeeEntity.setDoe(new Timestamp(new Date().getTime()));
		String actual=hibernateEmployeeDao.addEmployee(employeeEntity);
		assertEquals("success", actual);
		EmployeeEntity entity=hibernateEmployeeDao.findEmployeeByEmpid("E9990");
		assertEquals("simon@gmail.com", entity.getEmail());
		assertEquals("Male", entity.getGender());
		assertEquals("Simon", entity.getName());
	}
	
	

	@Test
	public void testFindEmployeeByEmpid() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testFindEmployee() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testFindEmployeeInt() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDeleteEmployeeByEmpId() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAuthUser() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDeleteEmployeeByRowId() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testFindImageRowid() {
		fail("Not yet implemented");
	}

}
*/