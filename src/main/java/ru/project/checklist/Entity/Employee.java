package ru.project.checklist.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
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
    private int id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
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

}
