package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf =  con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! get
        Student06 student1 = session.get(Student06.class,1001);
        System.out.println(student1);

        //!!! HQL ile id'si 101 olan kitabi getir
        String hqlQuery1 = "FROM Book06 b WHERE b.id=101";
        Book06 book1 = session.createQuery(hqlQuery1,Book06.class).uniqueResult();
        System.out.println(book1);

        //!!! HQL, bir ogrencinin kitaplarini ogrencinin id'sine gore getirelim(1001)
        String hqlQuery2 = "SELECT b.id,b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> resultList1 = session.createQuery(hqlQuery2).getResultList();
        resultList1.forEach(oa->System.out.println(Arrays.toString(oa)));

        //!!! Get, bir ogrencinin kitaplarini ogrencinin id'sine gore getirelim(1001)
        Student06 student2 = session.get(Student06.class,1001);
        System.out.println(student2.getBookList());

        tx.commit();
        session.close();
        sf.close();
    }
}
