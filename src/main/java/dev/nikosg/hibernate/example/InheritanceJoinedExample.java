package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Teacher3;
import dev.nikosg.hibernate.example.entity.Student3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceJoinedExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student3.class)
                .addAnnotatedClass(Teacher3.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student3 student = new Student3("Nikos", "Doe", "a@mail.com", "myCourse");
            Teacher3 teacher = new Teacher3("Jim", "Do2", "a2@ma.co", 100.00);

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
