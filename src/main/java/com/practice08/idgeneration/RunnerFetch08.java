package com.practice08.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer08.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1) ismi Gandalf olan developer'in id bilgisini getir.
        String hqlQuery = "SELECT d.id FROM Developer08 d WHERE d.name='Gandalf'";
        List<Object> resultList = session.createQuery(hqlQuery).getResultList();
        resultList.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();
    }
}
