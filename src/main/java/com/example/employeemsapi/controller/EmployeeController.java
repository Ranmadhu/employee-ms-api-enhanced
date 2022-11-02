package com.example.employeemsapi.controller;

import com.example.employeemsapi.entity.Employee;
import com.example.employeemsapi.exception.EmployeeException;
import com.example.employeemsapi.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
    public ResponseEntity<Employee> getAllEmployees() throws EmployeeException{
        List<Employee> response = null;
        response = employeeService.getAllEmployees();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable int employeeId) throws EmployeeException {
        return new ResponseEntity<Employee>(employeeService.getSingleEmployee(employeeId), HttpStatus.OK);
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
