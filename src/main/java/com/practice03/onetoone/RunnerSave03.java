package com.practice03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Computer com1 = new Computer(101,"10001","Mac");
        Computer com2 = new Computer(102,"10002","MSI");
        Computer com3 = new Computer(103,"10003","Hp");

        Developer03 dev1=new Developer03(1,"Harry Potter","hp@gmail.com","backend",com1);
        Developer03 dev2=new Developer03(2,"Shrek","shrek@gmail.com","frontend",com2);
        Developer03 dev3=new Developer03(3,"Jack Sparrow","jack@gmail.com","mobile",com3);

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);

        session.save(com1);
        session.save(com2);
        session.save(com3);

        tx.commit();
        session.close();
        sf.close();
    }
}
