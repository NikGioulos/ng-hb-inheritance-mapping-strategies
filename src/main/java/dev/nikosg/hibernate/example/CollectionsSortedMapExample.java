package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Customer5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;

public class CollectionsSortedMapExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer5.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer5 customer = new Customer5("Nikos", "Gio", "a@mail.com");
            SortedMap<String, String> images = customer.getImages();

            images.put("img1.jpeg", "Image 1");
            images.put("img2.jpeg", "Image 2");
            images.put("img3.jpeg", "Image 3");
            images.put("img3.jpeg", "Image 4"); //Duplicate, allowed in List
            images.put("img4.jpeg", "Image 5");

            session.beginTransaction();

            System.out.println("saving...");
            session.persist(customer);

            long id = 1;
            Customer5 fetchedCustomer = session.get(Customer5.class, id);
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
