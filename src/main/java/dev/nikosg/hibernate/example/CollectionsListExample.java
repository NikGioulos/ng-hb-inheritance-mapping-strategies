package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Customer2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CollectionsListExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer2.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer2 customer = new Customer2("Nikos", "Gio", "a@mail.com");
            List<String> images = customer.getImages();

            images.add("img1.jpeg");
            images.add("img2.jpeg");
            images.add("img3.jpeg");
            images.add("img3.jpeg"); //Duplicate, allowed in List
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
