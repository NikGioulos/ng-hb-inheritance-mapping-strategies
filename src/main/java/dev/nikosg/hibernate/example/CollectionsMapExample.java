package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Customer3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class CollectionsMapExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer3.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer3 customer = new Customer3("Nikos", "Gio", "a@mail.com");
            Map<String, String> images = customer.getImages();

            images.put("img1.jpeg", "Image 1");
            images.put("img2.jpeg", "Image 2");
            images.put("img3.jpeg", "Image 3");
            images.put("img3.jpeg", "Image 4"); //Duplicate, allowed in List
            images.put("img4.jpeg", "Image 5");

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
