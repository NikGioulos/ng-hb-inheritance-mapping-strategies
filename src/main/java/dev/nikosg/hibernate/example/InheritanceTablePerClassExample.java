package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Teacher2;
import dev.nikosg.hibernate.example.entity.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceTablePerClassExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student2.class)
                .addAnnotatedClass(Teacher2.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student2 student = new Student2("Nikos", "Doe", "a@mail.com", "myCourse");
            Teacher2 teacher = new Teacher2("Jim", "Do2", "a2@ma.co", 100.00);

            session.beginTransaction();

            System.out.println("saving...");

            session.persist(student);
            session.persist(teacher);

            session.getTransaction().commit();

            System.out.println("Done...");
        }finally {
            session.close();
            factory.close();
        }

    }
}
