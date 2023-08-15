package com.onesoft.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler(NameNotFoundException.class)
public ResponseEntity<Object> NamenotHandling (NameNotFoundException n){
	return new ResponseEntity<>(n.getMessage(),HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> AgeException (AgeException a){
		return new ResponseEntity<>(a.getMessage(),HttpStatus.NOT_FOUND);
}}