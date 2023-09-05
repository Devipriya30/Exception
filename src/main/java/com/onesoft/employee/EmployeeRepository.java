package com.onesoft.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
@Query(value="SELECT * FROM employee_details WHERE SALARY>=?",nativeQuery=true)
public List<Employee> setEmployeeBySalary(int salary);
@Query(value="SELECT * FROM employee_details WHERE Id>=?",nativeQuery=true)
public List<Employee> setEmployeeByid(int id);
@Query(value="SELECT MAX(SALARY) FROM employee_details",nativeQuery=true)
public int setEmployeeMax();
@Query(value="SELECT * FROM employee_details order by Name ASC",nativeQuery=true)
public List<String>OrderEmployeeName();
@Query("Select e from Employee e where e.gender=:gender")
public List<String>getEmp7(@Param("gender")String gender);
@Query("Select e from Employee e where e.name=:name")
public List<String> getEmp6(@Param("name")String name);
@Query("Select e from Employee e where e.salary>=:salary")
public List<String> getEmp4(@Param("salary")String salary);
@Query("Select e from Employee e where e.name=:name")
public List<String> getEmployeeName1(@Param("name")String name);

}




