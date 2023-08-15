package com.onesoft.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
@Query(value="SELECT * FROM employee_details WHERE SALARY>=?",nativeQuery=true)
public List<Employee> setEmployeeBySalary(int salary);
@Query(value="SELECT * FROM employee_details WHERE Id>=?",nativeQuery=true)
public List<Employee> setEmployeeByid(int id);
@Query(value="SELECT MAX(SALARY) FROM employee_details",nativeQuery=true)
public int setEmployeeMax();
@Query(value="SELECT * FROM employee_details order by Name ASC",nativeQuery=true)
public List<String>OrderEmployeeName();
}


