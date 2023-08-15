package com.onesoft.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRep;
	//exception method also
	public String addEmployee( Employee e)  {
		empRep.save(e);
		return "suseccfully added";
	}
	
	
	public Employee addEmployee1( int id) {
		return empRep.findById(id).get();
		}
	public String addEmployee2( List<Employee> emp){
		 empRep.saveAll(emp);
		 return "List of employee";
	}
	//all employee
	public List<Employee> getEmp(){
		return empRep.findAll();
	}
	public String delemp(int id){
	    empRep.deleteById(id);
	    return "delete sucessfully";
	}
	public String updage( Employee emp) {
		empRep.save(emp);
		return "update sucessfully";
		
	}
	public String delall(){
		 empRep.deleteAll();
		 return "delete sucessfully";
	}
	public List<Employee> setEmployeeBySalary( int salary){
		return empRep.setEmployeeBySalary(salary);
		}
	public List<Employee> setEmployeeByid( int id){
		return empRep.setEmployeeByid(id);
		}
	public int setEmployeeMax(){
		return empRep.setEmployeeMax();
		}
	public List<String> OrderEmployeeName() {
		return empRep.OrderEmployeeName();
	}
}
