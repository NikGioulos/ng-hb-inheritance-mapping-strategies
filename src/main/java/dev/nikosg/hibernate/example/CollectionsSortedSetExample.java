package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Customer4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CollectionsSortedSetExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer4.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer4 customer = new Customer4("Nikos", "Gio", "a@mail.com");
            Set<String> images = customer.getImages();

            images.add("img1.jpeg");
            images.add("img2.jpeg");
            images.add("img3.jpeg");
            images.add("img3.jpeg"); //Duplicate, filtered at java level
            images.add("img4.jpeg");

            session.beginTransaction();

            System.out.println("saving...");
            session.persist(customer);

            long id = 1;
            Customer4 fetchedCustomer = session.get(Customer4.class, id);
            System.out.println("Customer Details"+fetchedCustomer);
            System.out.println("The associated images"+fetchedCustomer.getImages());
            session.getTransaction().commit();


            System.out.println("Done...");
        }finally {
            session.close();
            factory.close();
        }

    }
}
