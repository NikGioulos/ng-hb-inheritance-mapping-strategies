package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Status;
import dev.nikosg.hibernate.example.entity.Customer8;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EnumsExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer8.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer8 c1 = new Customer8("Nikos", "Doe", "a@mail.com", Status.ACTIVE);
            Customer8 c2 = new Customer8("John", "Do2", "a2@mail.co", Status.DORMANT);

            session.beginTransaction();

            System.out.println("saving...");

            session.persist(c1);
            session.persist(c2);

            session.getTransaction().commit();

            System.out.println("Done...");
        }finally {
            session.close();
            factory.close();
        }

    }
}
