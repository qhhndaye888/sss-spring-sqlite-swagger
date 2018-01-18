package com.sqlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sqlite.dao.HabbitDao;
import com.sqlite.entities.Habbit;
 
@CrossOrigin(maxAge = 3600)
@RestController
public class HabbitController {
	@Autowired
	HabbitDao habbitDao;
	
	@RequestMapping(value = "/habbits", method = RequestMethod.GET)
	public ResponseEntity<List<Habbit>> getDepartments() throws Exception {
		List<Habbit> list = this.habbitDao.findAll();
		return new ResponseEntity<List<Habbit>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
