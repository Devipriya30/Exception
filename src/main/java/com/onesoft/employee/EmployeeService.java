package com.onesoft.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	
	
	public Employee addEmployee1(int id) {
		return empDao.addEmployee1(id);
	}
	public String addEmployee2( List<Employee> emp){
		return empDao.addEmployee2(emp);
	}
	
	
	public String delemp(int id){
		return empDao.delemp(id);
	}
	public String updage(Employee emp) {
		return empDao.updage(emp);
	}
	
	public String delall(){
		return empDao.delall();
	}
	//EXCEPTION IN NAME
	public List<Employee> getEmployeeName( String name)throws NameNotFoundException{
		List<Employee>allemp=empDao.getEmp();
		List<Employee>allname=allemp.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
		if(allname.isEmpty()) {
			throw new NameNotFoundException("name is null");
		}
		else {
			return allname;
		}
	}

	//employee name only
	public List<String> getEmp1(){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().map(x->x.getName()).toList();
		}
//employee gender
	public List<String> getEmp2(){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().map(x->x.getGender()).toList();
		}
	//employee age
	public List<Employee> getEmp3(int age)throws AgeException{
		List<Employee>allEMP=empDao.getEmp();
		List<Employee>allAge=allEMP.stream().filter(x->x.getAge()==age).toList();
		if(allAge.isEmpty()) {
			throw new AgeException("give age not correect");
		}
		else {
			return allAge;
		}
		}
	//employee salary
	public List<Integer> getEmp4(){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().map(x->x.getSalary()).toList();
		}
	
	public List<Integer> getEmp5(){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().map(x->x.getSalary()).toList();
		}
	public List<Employee> getEmp6(){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().map(x->{
			if(x.getAge()>=30&&x.getAge()<=35) {
				x.setSalary(x.getSalary()+x.getSalary()*10/100);
			}
			if(x.getAge()>=35&&x.getAge()<=40) {
				x.setSalary(x.getSalary()+x.getSalary()*15/100);
			}
			if(x.getAge()>=40&&x.getAge()<=50) {
				x.setSalary(x.getSalary()+x.getSalary()*20/100);
			}
		return x;
		}).collect(Collectors.toList());
		}
	public List<String> getEmp7(String gender){
		List<Employee>allEMP=empDao.getEmp();
		return allEMP.stream().filter(x->x.getGender().equalsIgnoreCase(gender)).map(x->x.getName()).toList();
		}
	public List<Employee> setEmployeeBySalary( int salary){
		return empDao.setEmployeeBySalary(salary);
		}
	public List<Employee> setEmployeeByid( int id){
		return empDao.setEmployeeByid(id);
		}
	public int setEmployeeMax(){
		return empDao.setEmployeeMax();
		}
	public List<String> OrderEmployeeName() {
		return empDao.OrderEmployeeName();
	}
	public String addEmployee(Employee e)throws AgeException{
		try {
		if(e.getAge()<18 && e.getAge()>=50) {
	    	  throw new AgeException("invalid age is provided");
	      }
	      else {
	    	  return empDao.addEmployee(e);
	      }
		 
	}
		
	catch(AgeException a) {
		return a.getMessage();
	}

	}
	
}
