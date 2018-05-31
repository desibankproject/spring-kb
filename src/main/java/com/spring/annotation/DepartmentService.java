package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//<bean id="DepartmentService" class="com.spring.annotation.DepartmentService">
 //	 <property name="serviceName" value="Service Layer"/>
//<property name="departmentDao" ref="DepartmentDao"/>
//</bean>
//@Service , @Repository , @Controller
@Service("DepartmentService")
public class DepartmentService {
	
	@Autowired   //byType- @Qualifier - byName
	@Qualifier("dao")
	private DepartmentDao departmentDao;
	
	private  String serviceName="Service Layer";
	public void call() {
		System.out.println(departmentDao.hashCode());
		System.out.println("_@_@__@DepartmentService is called_@_@");
		System.out.println("Service Name is = "+serviceName);
		System.out.println("_#_#cool!!!!!!!!!!!!_#");
		departmentDao.foo();
	}
}
