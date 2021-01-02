package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TEACHER")
public class Teacher1 extends User1 {

    @Column(name = "SALARY")
    private Double salary;

    public Teacher1(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
