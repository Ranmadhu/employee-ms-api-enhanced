package com.example.employeemsapi;

import com.example.employeemsapi.entity.Employee;
import com.example.employeemsapi.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeMsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository employeeRepository) {
		return (args -> {
			insertJavaAdvocates(employeeRepository);
			System.out.println(employeeRepository.findAll());
		});
	}

	//Dummy data list for the initialization
	private void insertJavaAdvocates(EmployeeRepository employeesRepository) {
		employeesRepository.save(new Employee("John", "Doe", 21, "Intern", "Networking, Information Security"));
		employeesRepository.save(new Employee("Thomas", "Anderson", 34, "Software Engineer", "Spring Framework, Java"));
		employeesRepository.save(new Employee("Will", "Smith", 48, "HR Manager", "Talent Acquisition, HR Management, Marketing"));
		employeesRepository.save(new Employee("Johnny", "English", 25, "QA Engineer", "Testing, Quality Control"));
		employeesRepository.save(new Employee("Paul", "Douglas", 29, "Software Engineer", "DotNet, Databases"));
	}

}
