package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT4")
public class Student4 extends User4 {

    @Column(name = "COURSE")
    private String course;

    public Student4(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
