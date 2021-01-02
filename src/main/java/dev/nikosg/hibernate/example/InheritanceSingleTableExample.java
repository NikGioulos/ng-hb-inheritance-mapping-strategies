package dev.nikosg.hibernate.example;

import dev.nikosg.hibernate.example.entity.Teacher1;
import dev.nikosg.hibernate.example.entity.Student1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceSingleTableExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student1.class)
                .addAnnotatedClass(Teacher1.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student1 student = new Student1("Nikos", "Doe", "a@mail.com", "myCourse");
            Teacher1 teacher = new Teacher1("Jim", "Do2", "a2@ma.co", 100.00);

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
