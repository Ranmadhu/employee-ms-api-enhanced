package com.example.employeemsapi.service;

import com.example.employeemsapi.entity.Employee;
import com.example.employeemsapi.exception.EmployeeException;
import org.springframework.stereotype.Component;

import java.util.List;

//Runs business logics while communicating with the repository layer.
@Component
public interface EmployeeService {

    public Employee createEmployee(Employee employees);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId) throws EmployeeException;

    public List<Employee> getEmployeesByFirstName(String firstName) throws EmployeeException;

    public List<Employee> getEmployeesByLastName(String lastName) throws EmployeeException;

    public List<Employee> getEmployeesByAge(int age) throws EmployeeException;

    public Employee updateEmployee(Employee employees);

    public void deleteEmployee(int employeeId) throws EmployeeException;

}
