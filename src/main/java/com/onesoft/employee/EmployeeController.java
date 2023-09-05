package com.onesoft.employee;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	static Logger log=Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService empser;
	//post exception method also
	@PostMapping(value="/add")
	public String addEmployee(@RequestBody Employee e) throws AgeException {
		return empser.addEmployee(e);
	}
	//2...........integer get 
	@GetMapping(value="/add1")
	public List<Employee> addEmployee1() {
		PropertyConfigurator.configure("log.properties");
		log.info(empser.addEmployee1());
		return empser.addEmployee1();
	}
	@PostMapping(value="/setList")
	public String addEmployee2(@RequestBody List<Employee> emp){
		return empser.addEmployee2(emp);
	}
	@GetMapping(value="/getmapping/{name}")
		public List<Employee> getEmployeeName(@PathVariable String name)throws NameNotFoundException{
			return empser.getEmployeeName(name);
		}
	@GetMapping(value="/getByName2/{name}")
	public List<Employee> getEmployeeName1(@PathVariable String name){
		return empser.getEmployeeName1(name);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String delemp(@PathVariable int id){
		return empser.delemp(id);
	}
	@PutMapping(value="/update")
	public String updage(@RequestBody Employee emp) {
		return empser.updage(emp);
	}
	@DeleteMapping(value="/deleteall")
	public String delall(){
		return empser.delall();
	}
	//1............employee name only
	@GetMapping(value="/getEmp1")
	public List<String> getEmp1(){
		return empser.getEmp1();
	}
	//2......gender
	@GetMapping(value="/getEmp2")
	public List<String> getEmp2(){
		return empser.getEmp2();
	}
	//3......id
	@GetMapping(value="/getEmp3/{age}")
	public List<Employee> getEmp3(@PathVariable int age)throws AgeException{
		return empser.getEmp3(age);
	}
	//4......salary
	@GetMapping(value="/getEmp4")
	public List<Integer> getEmp4(){
		return empser.getEmp4();
	}
	//5.......yearOfExperience
	@GetMapping(value="/getEmp5")
	public List<Integer> getEmp5(){
		return empser.getEmp5();
	}
	//6........age is get modify the salary
	@GetMapping(value="/getEmp6")
	public List<Employee> getEmp6(){
		return empser.getEmp6();
	}
	//7..........female name only
	@GetMapping(value="/getEmp7/{gender}")
	public List<String> getEmp7(@PathVariable String gender){
		return empser.getEmp7(gender);
	}
	//table in salary values 
	@GetMapping(value="/setEmployeeBySalary/{salary}")
	public List<Employee> setEmployeeBySalary(@PathVariable int salary){
	return empser.setEmployeeBySalary(salary);
	}
	//table id values
	@GetMapping(value="/setEmployeeById/{id}")
	public List<Employee> setEmployeeByid(@PathVariable int id){
	return empser.setEmployeeBySalary(id);
	}
	//table in maximum salary
	@GetMapping(value="/setEmployeeMax")
	public int setEmployeeMax(){
	return empser.setEmployeeMax();
	}
	//table in order the name
	@GetMapping(value="/orderbyname")
	public List<String> OrderEmployeeName() {
		System.out.println("exception2");
		return empser.OrderEmployeeName();
	}
	//employeecontroller for cardetails get
	@Autowired
	RestTemplate rest;
	//RestTemplate rest=new RestTemplate();
	@GetMapping(value="/getEmployeeviaCar")
	public List<Car> getEmployeeviaCar(){
		String url="http://localhost:8081/car/check";
		ResponseEntity<List<Car>> response=rest.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>(){});
	List<Car> value=response.getBody();
	return value;
	}
	@Autowired
	RestTemplate rest1;
//	RestTemplate rest1=new RestTemplate();
	@GetMapping(value="/getCaridviaemployee/{price}")
	public Car getcarIdviaemployee(@PathVariable int price){
		String url="http://localhost:8081/car/add1/";
		ResponseEntity<Car> response=rest1.exchange(url+price,HttpMethod.GET,null,Car.class);
	Car value=response.getBody();
	return value;
	}
	
	
	
}
