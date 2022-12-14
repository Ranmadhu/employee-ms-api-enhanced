package com.example.employeemsapi.controller;

import com.example.employeemsapi.entity.Employee;
import com.example.employeemsapi.exception.EmployeeException;
import com.example.employeemsapi.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
//Directs traffic and route requests.
//User requests come to the controller.
//Controller directs them to the Interface.
@Api(value = "CRUD Operations")
@Component
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Defining HTTP requests.
    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employees) {
        return new ResponseEntity<>(employeeService.createEmployee(employees), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeException{
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) throws EmployeeException {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeesByFirstName(@PathVariable String firstName) throws EmployeeException {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Employee>> getEmployeesByLastName(@PathVariable String lastName) throws EmployeeException {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Employee>> getEmployeesByAge(@PathVariable int age) throws EmployeeException {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByAge(age), HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employees) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employees), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) throws EmployeeException{
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
