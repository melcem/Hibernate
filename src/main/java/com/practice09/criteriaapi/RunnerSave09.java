package com.practice09.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {

        Developer09 dev1 = new Developer09("Henry",5000);
        Developer09 dev2 = new Developer09("John",7000);
        Developer09 dev3 = new Developer09("Marry",8000);
        Developer09 dev4 = new Developer09("Homer",7000);
        Developer09 dev5 = new Developer09("Niche",9000);
        Developer09 dev6 = new Developer09("Mick",8000);
        Developer09 dev7 = new Developer09("Jerry",8500);
        Developer09 dev8 = new Developer09("Tom",10000);
        Developer09 dev9 = new Developer09("Micheal",7000);
        Developer09 dev10 = new Developer09("Rob",6500);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(dev4);
        session.save(dev5);
        session.save(dev6);
        session.save(dev7);
        session.save(dev8);
        session.save(dev9);
        session.save(dev10);

        tx.commit();
        session.close();
        sf.close();
    }
}
