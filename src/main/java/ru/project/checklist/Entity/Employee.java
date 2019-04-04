package ru.project.checklist.Entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    @OneToMany
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee manager;
    @OneToOne
    @JoinColumn(name="POSITION_ID")
    private Position position;
    private int salary;

}
