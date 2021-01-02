package dev.nikosg.hibernate.example.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

//Mapping the Collection: SortedSet

//create table IMAGE4 (
// CUSTOMERID bigint not null,
// FILENAME varchar(255)
// )
//create table CUSTOMER4 (
// id bigint generated by default as identity,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// primary key (id)
// )
//alter table IMAGE4
// add constraint FKg8c25wr6hm04ml6iig9veqsfx foreign key (CUSTOMERID) references CUSTOMER4

@Entity
@Table(name="CUSTOMER4")
public class Customer4 {

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
            name = "IMAGE4", //this is the table name
            joinColumns = @JoinColumn(name = "CUSTOMERID") //this is the FK on the table
    )
    @OrderBy("FILENAME desc")
    @Column(name = "FILENAME")
    private Set<String> images = new LinkedHashSet<>();

    //hibernate requires a no-arg constructor in order to retrieve data
    public Customer4(){

    }

    public Customer4(String firstName, String lastName, String email) {
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