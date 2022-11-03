package com.example.employeemsapi.serviceImplementation;

import com.example.employeemsapi.entity.Employee;
import com.example.employeemsapi.exception.EmployeeException;
import com.example.employeemsapi.repository.EmployeeRepository;
import com.example.employeemsapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employees) {
        employeeRepository.save(employees);
        Optional<Employee> employee = employeeRepository.findById(employees.getEmployeeId());
        return employee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new EmployeeException("No employee records exist for given ID.");
        }
    }

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) throws EmployeeException {
        List<Employee> allEmployees = getAllEmployees();
        List<Employee> employeesWithName = new ArrayList<>();

        for (Employee employee: allEmployees) {
            if (firstName.equals(employee.getFirstName())) {
                employeesWithName.add(employee);
            }
        }
        return employeesWithName;
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) throws EmployeeException {
        List<Employee> allEmployees = getAllEmployees();
        List<Employee> employeesWithName = new ArrayList<>();

        for (Employee employee: allEmployees) {
            if (lastName.equals(employee.getLastName())) {
                employeesWithName.add(employee);
            }
        }
        return employeesWithName;
    }

    @Override
    public List<Employee> getEmployeesByAge(int age) throws EmployeeException {
        List<Employee> allEmployees = getAllEmployees();
        List<Employee> employeesWithName = new ArrayList<>();

        for (Employee employee: allEmployees) {
            if (age == employee.getAge()) {
                employeesWithName.add(employee);
            }
        }
        return employeesWithName;
    }

    @Override
    public Employee updateEmployee(Employee employees) {
        employeeRepository.save(employees);
        Optional<Employee> employee = employeeRepository.findById(employees.getEmployeeId());
        return employee.get();
    }

    @Override
    public void deleteEmployee(int employeeId) throws EmployeeException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isPresent()) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new EmployeeException("No employee records exist for given ID.");
        }
    }
}
