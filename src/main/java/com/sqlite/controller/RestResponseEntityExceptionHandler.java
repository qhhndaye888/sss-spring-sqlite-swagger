package com.sqlite.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sqlite.exception.CurdException;
import com.sqlite.models.ErrorStatus;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private Logger logger = Logger.getLogger(this.getClass());

    @ExceptionHandler(value = { CurdException.class})
    protected ResponseEntity<ErrorStatus> handleConflict(RuntimeException ex, WebRequest request) {
    	ErrorStatus bodyOfResponse = new ErrorStatus();
    	bodyOfResponse.setException(ex.toString());
    	ex.printStackTrace();
    	logger.error(ex.getMessage());
        return new ResponseEntity<ErrorStatus>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<ErrorStatus> unknowException(Exception ex, WebRequest request) {
    	ErrorStatus bodyOfResponse = new ErrorStatus();
    	ex.printStackTrace();
    	logger.error(ex.getMessage());
    	bodyOfResponse.setException(ex.toString());
        return new ResponseEntity<ErrorStatus>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
