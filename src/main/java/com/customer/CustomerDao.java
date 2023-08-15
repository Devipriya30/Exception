package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository custRep;
	public String getCustomer(Customer c) {
		 custRep.save(c);
		 return "Sucessfully added";
	}
	public Customer getbankid(int id,String name){
		 Customer d=custRep.findById(id).get();
		 d.setName(name);
		 custRep.save(d);
		 return d;
	}
	public Customer getbankidandname( int id, int acoountNumber){
		Customer d1=custRep.findById(id).get();
		d1.setAcoountNumber(acoountNumber);
		custRep.save(d1);
		
		return d1;
	}
}
