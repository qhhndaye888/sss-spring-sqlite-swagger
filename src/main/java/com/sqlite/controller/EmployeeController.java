package com.sqlite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sqlite.dao.EmployeeDao;
import com.sqlite.entities.Employee;
import com.sqlite.entities.Habbit;
import com.sqlite.models.EmployeeVo;
@CrossOrigin(maxAge = 3600)
@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getDepartments() throws Exception {
		List<Employee> list = this.employeeDao.findAll();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployees(@RequestBody EmployeeVo employeeVo) throws Exception{
		Employee employeeDto = new Employee();
		BeanUtils.copyProperties(employeeVo, employeeDto);
		List<Habbit> list = new ArrayList<Habbit>();
		employeeVo.getHabbits().forEach((v)->{
			list.add(new Habbit(v.getId(),v.getName()));
		});
		employeeDto.setHabbits(list);
		employeeDto= this.employeeDao.save(employeeDto);
		return new ResponseEntity<Employee>(employeeDto, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> findOneById(@PathVariable Integer id, @RequestBody  EmployeeVo employee) throws Exception{
		
		Employee EmployeeDto= this.employeeDao.findOne(id);
		return new ResponseEntity<Employee>(EmployeeDto, new HttpHeaders(), HttpStatus.OK);
	}
	
 
}
