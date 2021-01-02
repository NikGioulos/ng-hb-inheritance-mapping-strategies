package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Customer1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CollectionsSetExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer1.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer1 customer = new Customer1("Nikos", "Gio", "a@mail.com");
            Set<String> images = customer.getImages();

            images.add("img1.jpeg");
            images.add("img2.jpeg");
            images.add("img3.jpeg");
            images.add("img3.jpeg"); //Duplicate, filtered at java level by HashSet!!!
            images.add("img4.jpeg");

            session.beginTransaction();

            System.out.println("saving...");
            session.persist(customer);

            session.getTransaction().commit();
            System.out.println("Done...");
        }finally {
            session.close();
            factory.close();
        }

    }
}
