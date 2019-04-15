package ru.project.checklist.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "Employee")
@NoArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;
    private int salary;


    public String getPosition() {
        return position.getName();
    }

    public String getManagerName() {
        if(manager==null) return "отсутствует";
        return manager.name;
    }

    public Employee(String name, LocalDate birthday, Employee manager, Position position, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.manager = manager;
        this.position = position;
        this.salary = salary;
    }
}
