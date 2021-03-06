package dev.nikosg.hibernate.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mapping : Enums

//create table CUSTOMER8 (
// id bigint generated by default as identity,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// STATUS varchar(255),
// primary key (id)
// )

@Entity
@Table(name="CUSTOMER8")
public class Customer8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    public Customer8(String firstName, String lastName, String email, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Student8{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
