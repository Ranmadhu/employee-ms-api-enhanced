package com.example.employeemsapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
public class Employee {

    //Adding an auto-incrementing primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "employee_class", nullable = false)
    private String employeeClass;

    @Column(name = "subjects", nullable = false)
    private String subjects;

    public Employee (String firstName,
                      String lastName,
                      int age,
                      String employeeClass,
                      String subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.employeeClass = employeeClass;
        this.subjects = subjects;
    }

    public Employee() {
        //
    }
}
