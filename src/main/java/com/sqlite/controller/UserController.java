package com.sqlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.sqlite.dao.EmployeeDao;
import com.sqlite.models.EmployeeVo;
 
public class UserController<User> {
	   @Autowired
	   EmployeeDao employeeDao ;
 
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
 
	    public ResponseEntity<List<EmployeeVo>> listAllUsers() {
		   System.out.println("hello Users");
		   this.employeeDao.findAll().iterator() ;
	        return  null; 
	    }
}
