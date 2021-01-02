package dev.nikosg.hibernate.example.entity;

import javax.persistence.*;

//Mapping the Inheritance: Table Per Class Strategy

//Table has columns for all fields in inheritance tree

//create table hibernate_sequences (
// sequence_name varchar(255) not null,
// next_val bigint,
// primary key (sequence_name)
// )
//insert into hibernate_sequences(sequence_name, next_val) values ('default',0)

//create table TEACHER2 (
// id bigint not null, EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// SALARY double,
// primary key (id)
// )

//create table STUDENT2 (
// id bigint not null,
// EMAIL varchar(255),
// FIRSTNAME varchar(255),
// LASTNAME varchar(255),
// COURSE varchar(255),
// primary key (id)
// )

//Hibernate: select tbl.next_val from hibernate_sequences tbl where tbl.sequence_name=? for update with rs
//Hibernate: update hibernate_sequences set next_val=?  where next_val=? and sequence_name=?
//Hibernate: select tbl.next_val from hibernate_sequences tbl where tbl.sequence_name=? for update with rs
//Hibernate: update hibernate_sequences set next_val=?  where next_val=? and sequence_name=?
//Hibernate: insert into STUDENT2 (EMAIL, FIRSTNAME, LASTNAME, COURSE, id) values (?, ?, ?, ?, ?)
//Hibernate: insert into TEACHER2 (EMAIL, FIRSTNAME, LASTNAME, SALARY, id) values (?, ?, ?, ?, ?)


@Entity
@Table(name = "USER2") //this annotation is redundant if Inheritance Strategy is TablePerClass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User2 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)//since the strategy is TABLE_PER_CLASS
    //since entities span multiple tables, the next generated ID value can be maintained in a separate (sequence) table
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    public User2(String firstName, String lastName, String email) {
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
