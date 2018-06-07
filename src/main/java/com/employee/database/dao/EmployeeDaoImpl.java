package com.employee.database.dao;

import java.io.IOException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Repository("EmployeeDaoImpl")
@Scope("singleton")
@Lazy(false)
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	@Qualifier("jdbcDataSource")
	private DataSource dataSource;

	//IllegalTransactionStateException
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public String authUser(String username,String password) {
		 boolean b=TransactionSynchronizationManager.isActualTransactionActive();
		 if(b) {
			 System.out.println("Ahahah transaction is working here!!!!!!!!!! ");
		 }
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="select count(*) from auth_tbl where username=? and password=?";
	 	int count=jdbcTemplate.queryForObject(sql, Integer.class,new Object[]{username,password});
	 	System.out.println("count - "+count);
	 	return count==0?"fail":"pass";
	}
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor=IOException.class,noRollbackFor=NumberFormatException.class,timeout=3000)
	@Override
	public String addEmployee(EmployeeEntity employeeEntity) {
		 boolean b=TransactionSynchronizationManager.isActualTransactionActive();
		 if(b) {
			 System.out.println("Ahahah transaction is working here!!!!!!!!!! ");
		 }else{
			 System.out.println("sorry transaction is not  enabled!!!!!!!!!! ");
		 }
	 	 System.out.println("add employee method is called in dao layer!!!!!!");
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 System.out.println(employeeEntity);
	 	 LobHandler lobHandler=new DefaultLobHandler();
         SqlLobValue sqlLobValue=new SqlLobValue(employeeEntity.getPhoto(),lobHandler);
         int[] dataType=new int[] { Types.VARCHAR, Types.VARCHAR,
                 Types.VARCHAR, Types.VARCHAR,Types.BLOB,Types.VARCHAR,Types.TIMESTAMP };
	 	 String sql="insert into employee_tbl(empid,name,email,gender,photo,address,doe) values(?,?,?,?,?,?,?)";
	 	 Object[] args=new Object[]{employeeEntity.getEmpid(),employeeEntity.getName(),employeeEntity.getEmail(),employeeEntity.getGender(),sqlLobValue,employeeEntity.getAddress(),employeeEntity.getDoe()};
  	   	 jdbcTemplate.update(sql, args,dataType);
  	   	 jdbcTemplate.update(sql, args,dataType);
  	   	 jdbcTemplate.update(sql, args,dataType);
  	   	 jdbcTemplate.update(sql, args,dataType);
  	   	 jdbcTemplate.update(sql, args,dataType);
		 return "success";
	}
	
	@Override
	public String updateEmployee(EmployeeEntity employeeEntity) {
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 System.out.println(employeeEntity);
	 	 String sql="update employee_tbl set  name=?,email=?,gender=?,address=? where empid=?";
	 	 Object[] args=new Object[]{employeeEntity.getName(),employeeEntity.getEmail(),employeeEntity.getGender(),employeeEntity.getAddress(),employeeEntity.getEmpid()};
  	   	 jdbcTemplate.update(sql, args);
		 return "success";
	}


	@Override
	public byte[] findImageRowid(int rowid) {
	 	 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	 	 String sql="select photo from employee_tbl where rowid="+ rowid;
	 	 byte[] image=jdbcTemplate.queryForObject(sql, byte[].class);
	 	 return image;
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
