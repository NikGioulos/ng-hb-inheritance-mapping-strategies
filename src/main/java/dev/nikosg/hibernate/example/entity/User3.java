package dev.nikosg.hibernate.example.entity;

import javax.persistence.*;

//Mapping the Inheritance: JOINED Strategy

//create table TEACHER3 (
// SALARY double,
// id bigint not null,
// primary key (id)
// )
//create table STUDENT3 (
// COURSE varchar(255),
// id bigint not null,
// primary key (id)
// )
//create table USER3 (
// id bigint generated by default as identity,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// primary key (id)
// )
//alter table TEACHER3 add constraint FKj5060crhr8qcd3xpccsv06e08 foreign key (id) references USER3
//alter table STUDENT3 add constraint FKhffns32wf1de0y86t1wkjrgrf foreign key (id) references USER3

//Hibernate: insert into USER3 (id, EMAIL, FIRSTNAME, LASTNAME) values (default, ?, ?, ?)
//Hibernate: insert into STUDENT3 (COURSE, id) values (?, ?)
//Hibernate: insert into USER3 (id, EMAIL, FIRSTNAME, LASTNAME) values (default, ?, ?, ?)
//Hibernate: insert into TEACHER3 (SALARY, id) values (?, ?)

@Entity
@Table(name = "USER3")
@Inheritance(strategy = InheritanceType.JOINED) //Both superclass and concrete classes are mapped to tables
public abstract class User3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    public User3(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}