package com.hb13.get_load;

import com.hb12.caching.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.crypto.SecretKeyFactory;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13();
        student1.setName("John Lennon");
        student1.setMathGrade(65);

        Student13 student2 = new Student13();
        student2.setName("Mark Enjoy");
        student2.setMathGrade(85);

        Student13 student3 = new Student13();
        student3.setName("Mary Table");
        student3.setMathGrade(80);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();
    }
}
