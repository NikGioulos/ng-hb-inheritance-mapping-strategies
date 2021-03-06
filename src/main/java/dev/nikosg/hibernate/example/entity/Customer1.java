package dev.nikosg.hibernate.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Mapping the Collection: Set

// create table IMAGE1 (
// CUSTOMERID bigint not null,
// FILENAME varchar(255)
// )

// create table CUSTOMER1 (
// id bigint generated by default as identity,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// primary key (id)
// )

// Alter table IMAGE1
//  add constraint FKcya9k2hy2tshhvgstjl97tngk foreign key (CUSTOMERID) references CUSTOMER1

@Entity
@Table(name="CUSTOMER1")
public class Customer1 {

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
    //similar to @OneToMany except Target Object (Collection of Strings) is not an Entity
    @CollectionTable(
            name = "IMAGE1", //this is the table name
            joinColumns = @JoinColumn(name = "CUSTOMERID") //this is the FK on the table
    )
    @Column(name = "FILENAME")
    private Set<String> images = new HashSet<String>();


    public Customer1(String firstName, String lastName, String email) {
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

    public Set<String> getImages() {
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
