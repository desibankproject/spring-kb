package com.employee.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
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
	public String updateEmployee(EmployeeEntity employeeEntity) {
		EmployeeEntity demployeeEntity=super.getHibernateTemplate().get(EmployeeEntity.class, employeeEntity.getRowid());
		demployeeEntity.setAddress(employeeEntity.getAddress());
		demployeeEntity.setEmail(employeeEntity.getEmail());
		demployeeEntity.setGender(employeeEntity.getGender());
		demployeeEntity.setName(employeeEntity.getName());
		return "success";
	}

	@Override
	public String addEmployee(EmployeeEntity employeeEntity) {
		//spring will take care of what 
		//1. sessionFactory
		//2. session management
		//3. connection management
		//4. transaction management
		//5. Exception handling
		super.getHibernateTemplate().save(employeeEntity);
		return "success";
	}
	
	@Override
	public EmployeeEntity findEmployeeByEmpid(String empid) {
		//HQL - SQL  - HQL is database independent ? yes while SQL is database dependent and SQL is also known as native query
		List<EmployeeEntity> employeeList=(List<EmployeeEntity>)super.getHibernateTemplate().find("from EmployeeEntity where empid=?",empid);
		EmployeeEntity employeeEntity=new EmployeeEntity();
		if(employeeList.size()>0){
			employeeEntity=employeeList.get(0);
		}
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> findEmployee() {
		//HQL - SQL  - HQL is database independent ? yes while SQL is database dependent and SQL is also known as native query
		List<EmployeeEntity> employeeList=(List<EmployeeEntity>)super.getHibernateTemplate().find("from EmployeeEntity");
		return employeeList;
	}
	
	@Override
	public List<EmployeeEntity> findEmployee(int offeset) {
		//HQL - SQL  - HQL is database independent ? yes while SQL is database dependent and SQL is also known as native query
		//List<EmployeeEntity> employeeList=(List<EmployeeEntity>)super.getHibernateTemplate().find("from EmployeeEntity");
		System.out.println(")#)#)#)#)#ahaha it is working@");
		//select  * from laptops_tbl limit 0,5
		// 0 1 2 3 4
		//select  * from laptops_tbl limit 5,5
		DetachedCriteria criteria = DetachedCriteria.forClass(EmployeeEntity.class);
		List<EmployeeEntity>employeeList =(List<EmployeeEntity>)getHibernateTemplate().findByCriteria(criteria, offeset, 5);
		return employeeList;
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
	public byte[] findImageRowid(int rowid) {
		// TODO Auto-generated method stub
		return null;
	}

}
