package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Address;
import dev.nikosg.hibernate.example.entity.Customer7;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ComponentsEmbeddableExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer7.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer7 customer = new Customer7("Nikos", "Doe", "a@mail.com");

            Address homeAddress = new Address("par 62", "Athens", "12345");

            Address billAddress = new Address("ZAL 9", "Athens", "54321");

            session.beginTransaction();

            System.out.println("saving...");
            customer.setHomeAddress(homeAddress);
            customer.setBillingAddress(billAddress);
            session.persist(customer);

            session.getTransaction().commit();
            System.out.println("Done...");
        }finally {
            session.close();
            factory.close();
        }

    }
}
