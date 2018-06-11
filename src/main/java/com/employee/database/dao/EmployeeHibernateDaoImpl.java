package com.employee.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.database.dao.entity.EmployeeEntity;

@Repository("EmployeeHibernateDaoImpl")
@Scope("singleton")
@Transactional
public class EmployeeHibernateDaoImpl extends HibernateDaoSupport  implements  EmployeeDao {
	
	//below code will injection my sessionFactory inside HibernateDaoSupport class
	@Autowired
	@Qualifier("sessionFactory")
	public void setSpringManageSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public String addEmployee(EmployeeEntity employeeEntity) {
		//spring will take care of what 
		//1. sessionFactory
		//2. session management
		//3. connection management
		//4. transaction management
		//5. Exception handling
		getHibernateTemplate().save(employeeEntity);
		return "success";
	}

	@Override
	public List<EmployeeEntity> findEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeByEmpId(String empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String authUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeByRowId(String rowid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findImageRowid(int rowid) {
		// TODO Auto-generated method stub
		return null;
	}

}
