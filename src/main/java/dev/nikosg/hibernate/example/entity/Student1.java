package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STUDENT")
public class Student1 extends User1 {

    @Column(name = "COURSE")
    private String course;

    public Student1(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
