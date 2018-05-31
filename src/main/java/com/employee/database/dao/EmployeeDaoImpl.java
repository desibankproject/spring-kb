package com.employee.database.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("EmployeeDaoImpl")
@Scope("singleton")
@Lazy(false)
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	@Qualifier("jdbcDataSource")
	private DataSource dataSource;
	
	@Override
	public String authUser(String username,String password){
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="select count(*) from auth_tbl where username=? and password=?";
	 	int count=jdbcTemplate.queryForObject(sql, Integer.class,new Object[]{username,password});
	 	System.out.println("count - "+count);
	 	return count==0?"fail":"pass";
	}
	
	
	@Override
	public String addEmployee(EmployeeEntity employeeEntity) {
	 	 System.out.println("add employee method is called in dao layer!!!!!!");
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 System.out.println(employeeEntity);
	 	 String sql="insert into employee_tbl(empid,name,email,gender,address,doe) values(?,?,?,?,?,?)";
	 	 Object[] args=new Object[]{employeeEntity.getEmpid(),employeeEntity.getName(),employeeEntity.getEmail(),employeeEntity.getGender(),employeeEntity.getAddress(),employeeEntity.getDoe()};
  	   	 jdbcTemplate.update(sql, args);
		 return "success";
	}

	
	@Override
	public List<EmployeeEntity> findEmployee(){
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="select  rowid,empid,name,email,gender,address,doe from employee_tbl";
	 	List<EmployeeEntity>  employeeEntityList=jdbcTemplate.query(sql, new BeanPropertyRowMapper(EmployeeEntity.class));
	 	return employeeEntityList;
	}
	
	@Override
	public String deleteEmployeeByEmpId(String empid){
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="delete from employee_tbl where empid=?";
	 	 int row=jdbcTemplate.update(sql, new Object[]{empid});
	 	 //Ternary operator
		 return row==0?"record could not be deleted with empid "+empid:"record is deleted successfully with empid "+empid;
	}
	
	@Override
	public String deleteEmployeeByRowId(String rowid){
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="delete from employee_tbl where rowid=?";
	 	 int row=jdbcTemplate.update(sql, new Object[]{rowid});
	 	 //Ternary operator
		 return row==0?"notdelete":"deleted";
	}
}
