package dev.nikosg.hibernate.example.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

//Mapping the Collection: Map

//create table IMAGE3 (
// CUSTOMERID bigint not null,
// IMAGEDESCR varchar(255),
// FILENAME varchar(255) not null,
// primary key (CUSTOMERID, FILENAME)
// )

//create table CUSTOMER3 (
// id bigint generated by default as identity,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// primary key (id)
// )

// Alter table IMAGE3
//  add constraint FKd646wgobaet2k2x7mtxpvhfa6 foreign key (CUSTOMERID) references CUSTOMER3

@Entity
@Table(name="CUSTOMER3")
public class Customer3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @ElementCollection //this tells Hibernate that we are mapping a collection
    @CollectionTable(
            name = "IMAGE3", //this is the table name
            joinColumns = @JoinColumn(name = "CUSTOMERID"))
    @MapKeyColumn(name = "FILENAME") //this is the key of the Map
    @Column(name = "IMAGEDESCR") //this is the value of the Map
    private Map<String, String> images = new HashMap<>();


    public Customer3(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Map<String, String> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
