package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT3")
public class Student3 extends User3 {

    @Column(name = "COURSE")
    private String course;

    public Student3(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
