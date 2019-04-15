package ru.project.checklist.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
    private Collection<Employee> employees;
    public Position(String name) {
        this.name = name;
    }

}
