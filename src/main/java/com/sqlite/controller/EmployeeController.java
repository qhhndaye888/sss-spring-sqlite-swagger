package com.sqlite.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
import com.sqlite.entities.Department;
import com.sqlite.entities.Employee;
import com.sqlite.entities.Habbit;
import com.sqlite.exception.CurdException;
import com.sqlite.models.EmployeeVo;
import com.sqlite.models.HabbitVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@Api(value = "員工", description = "員工資料表")
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;

	private Logger logger = Logger.getLogger(this.getClass());

	@ApiOperation(value = "取得全部員工清單")
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees() throws Exception {
		List<Employee> list = this.employeeDao.findAll();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@ApiOperation(value = "新建員工資料")
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployees(@RequestBody EmployeeVo employeeVo) throws Exception {
		Employee employeeDto = new Employee();
		validator(employeeVo);
		BeanUtils.copyProperties(employeeVo, employeeDto);
		List<Habbit> list = new ArrayList<Habbit>();
		employeeVo.getHabbits().forEach((v) -> {
			list.add(new Habbit(v.getId(), v.getName()));
		});
		employeeDto.setHabbits(list);
		employeeDto.setDepartment(
				new Department(employeeVo.getDepartment().getId(), employeeVo.getDepartment().getName()));
		employeeDto = this.employeeDao.save(employeeDto);
		return new ResponseEntity<Employee>(employeeDto, new HttpHeaders(), HttpStatus.OK);
	}

	@ApiOperation(value = "id取得員工資料")
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> findOneById(@PathVariable Integer id, @RequestBody EmployeeVo employee)
			throws Exception {

		Employee EmployeeDto = this.employeeDao.findOne(id);
		return new ResponseEntity<Employee>(EmployeeDto, new HttpHeaders(), HttpStatus.OK);
	}

	@ApiOperation(value = "id更新員工資料")
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> udpateById(@PathVariable Integer id, @RequestBody EmployeeVo employeeVo)
			throws Exception {

		validator(employeeVo);
		Employee employeeDto = this.employeeDao.findOne(id);
		BeanUtils.copyProperties(employeeVo, employeeDto);
		employeeDto.setHabbits(new ArrayList<Habbit>());
	 
		for(HabbitVo h : employeeVo.getHabbits()) {
			Habbit habbit = new Habbit();
			BeanUtils.copyProperties(h, habbit);
			employeeDto.getHabbits().add(habbit);
		}
		employeeDto.setId(id);
	 
		employeeDto = this.employeeDao.saveAndFlush(employeeDto);
		return new ResponseEntity<Employee>(employeeDto, new HttpHeaders(), HttpStatus.OK);
	}

	private void validator(EmployeeVo employeeVo) throws CurdException {
		if (employeeVo.getEmployeeNo() == null || "".equals(employeeVo.getEmployeeNo())) {
			throw new CurdException("員工編號不得為空值");
		}
		if (employeeVo.getRocId() == null || "".equals(employeeVo.getRocId())) {
			throw new CurdException("身份證字號不得為空值");
		}
		if (employeeVo.getName() == null || "".equals(employeeVo.getName())) {
			throw new CurdException("姓名不得為空值");
		}

	}

	@ApiOperation(value = "id刪除員工資料")
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) throws Exception {
		boolean isSuccess = Boolean.FALSE;

		this.employeeDao.delete(id);
		isSuccess = Boolean.TRUE;

		return new ResponseEntity<Boolean>(isSuccess, new HttpHeaders(), HttpStatus.OK);

	}

}
