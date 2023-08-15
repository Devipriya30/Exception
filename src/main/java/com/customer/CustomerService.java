package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerService {
	@Autowired
	CustomerDao custDao;
	public String getCustomer( Customer c) {
		return custDao.getCustomer(c);
	}
	
	public Customer getbankid(int id, String name){
		return custDao.getbankid(id,name);
	}
	public Customer getbankidandname( int id, int acoountNumber){
		return custDao.getbankidandname(id,acoountNumber);
	}
}
