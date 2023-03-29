package com.practice02.embeddable;

import com.practice01.annotations.Developer01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Education edu1 = new Education("YTU","Computer Eng");
        Education edu2 = new Education("NC","Mathematics");

        Developer02 dev1=new Developer02(1,"Harry Potter","hp@gmail.com","backend",edu1);
        Developer02 dev2=new Developer02(2,"Shrek","shrek@gmail.com","frontend",edu2);
        Developer02 dev3=new Developer02(3,"Jack Sparrow","jack@gmail.com","mobile",edu1);

        Configuration con = new Configuration().configure().
                addAnnotatedClass(Developer02.class).addAnnotatedClass(Education.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);

        tx.commit();
        session.close();
        sf.close();
    }
}
