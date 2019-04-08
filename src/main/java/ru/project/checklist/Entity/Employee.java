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
@Table(name="Employee")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="manager_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee manager;
    @OneToOne
    @JoinColumn(name="POSITION_ID")
    private Position position;
    private int salary;


    public String getPosition() {
        return position.getName();
    }
    public String getManagerName() {
        return manager.getManagerName();
    }

    public Employee(String name, LocalDate birthday, Employee manager, Position position, int salary) {
        this.name = name;
        this.birthday = birthday;
        this.manager = manager;
        this.position = position;
        this.salary = salary;
    }
}
