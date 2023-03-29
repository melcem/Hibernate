package com.practice03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Developer03 dev1 = session.get(Developer03.class,1);
        System.out.println(dev1);
        System.out.println(dev1.getComputer());

        tx.commit();
        session.close();
        sf.close();
    }
}
