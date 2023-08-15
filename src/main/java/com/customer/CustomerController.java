package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class CustomerController {
	@Autowired
	CustomerService custser;
	@Autowired
	RestTemplate rest;
	//overide the ifsccode by using brand name
	@PostMapping(value="/getaddall")
	public String getCustomer(@RequestBody Customer c) {
	    String url1="http://localhost:8080/getBankIfsc/";
		ResponseEntity<String>response1=rest.exchange(url1+c.getBranch(), HttpMethod.GET,null,String.class);
		String s=response1.getBody();
		c.setIfscCode(s);
		return custser.getCustomer(c);
		}
	//get id override the name  without lost all data
	@PutMapping(value="/getBankId")
	public Customer getbankid(@RequestParam int id,@RequestParam String name){
		return custser.getbankid(id,name);
	}
	//bankaccountnumber using id
	@PutMapping(value="/getBankIdandAccountNumber")
	public Customer getbankidandname(@RequestParam int id,@RequestParam int acoountNumber){
		return custser.getbankidandname(id,acoountNumber);
	}
}
