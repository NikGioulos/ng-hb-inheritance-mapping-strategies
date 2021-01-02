package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Teacher4;
import dev.nikosg.hibernate.example.entity.Student4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceMappedSuperClassExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student4.class)
                .addAnnotatedClass(Teacher4.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student4 student = new Student4("Nikos", "Doe", "a@mail.com", "myCourse");
            Teacher4 teacher = new Teacher4("Jim", "Do2", "a2@ma.co", 100.00);

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
