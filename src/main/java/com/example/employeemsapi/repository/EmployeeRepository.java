package com.example.employeemsapi.repository;

import com.example.employeemsapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Acting as a data access object.
@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
}
