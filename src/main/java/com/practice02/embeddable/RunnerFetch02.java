package com.practice02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Developer02.class).addAnnotatedClass(Education.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //id=1 olan developerın tüm bilgilerini yazdırınız.
        Developer02 dev1=session.get(Developer02.class,1);
        System.out.println(dev1);

        //id=1 olan developerın sadece eğitim bilgilerini yazdırınız.
        System.out.println(dev1.getEducation());

        tx.commit();
        session.close();
        sf.close();
    }
}
