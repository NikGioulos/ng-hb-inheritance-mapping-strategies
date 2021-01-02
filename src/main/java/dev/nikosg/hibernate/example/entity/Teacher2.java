package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER2")
public class Teacher2 extends User2 {

    @Column(name = "SALARY")
    private Double salary;

    public Teacher2(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
