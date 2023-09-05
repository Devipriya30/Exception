package com.onesoft.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao {
	static Logger log=Logger.getLogger(EmployeeDao.class);
	
	@Autowired
	EmployeeRepository empRep;
	//exception method also
	public String addEmployee( Employee e)  {
		empRep.save(e);
		return "suseccfully added";
	}
	public List<Employee> getEmployeeName1(String name){
		return empRep.findAll();
	}
	
	
	public List<Employee> addEmployee1( ) {
		PropertyConfigurator.configure("log.properties");
		log.info(empRep.findAll());
		return empRep.findAll();
		}
	public String addEmployee2( List<Employee> emp){
		 empRep.saveAll(emp);
		 return "List of employee";
	}
//	public Employee addEmployee1( ) {
//		PropertyConfigurator.configure("log.properties");
//		log.info("Employeedao run");
//		return empRep.findById(id).get();
//		}
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
