package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.List;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       /* //!!! get ile student getir
        Student08 student1 = session.get(Student08.class,1001);
        System.out.println(student1);*/

        //!!! get ile book getir
        Book08 book1 = session.get(Book08.class,101);
        System.out.println(book1);

        /*String hqlQuery1 = "FROM Student08";
        List<Student08> resultList = session.createQuery(hqlQuery1,Student08.class).getResultList();
        resultList.forEach(t-> System.out.println(t));*/



        tx.commit();
        session.close();
        sf.close();
    }
}
