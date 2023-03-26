package com.practice01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer01.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Developer01 dev = session.get(Developer01.class,1);
        System.out.println(dev);

        tx.commit(); // sadece fetch islemi yapacaksak, commit olmasa da olur
        session.close();
        sf.close();
    }
}
