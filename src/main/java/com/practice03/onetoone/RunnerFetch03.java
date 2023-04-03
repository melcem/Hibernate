package com.practice03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1) id=1 olan developer'in tum bilgilerini getir
        Developer03 dev1 = session.get(Developer03.class,1);
        System.out.println(dev1);

        //2) id=103 olan computer'in tum bilgilerini getir
        Computer computer = session.get(Computer.class,103);
        System.out.println(computer);

        //3) id=102 olan computer'i kullanan developer'in tum bilgilerini getir
        Computer computer1 = session.get(Computer.class,102);
        System.out.println(computer1.getDeveloper());

        //4) id=3 olan developer'in kullandigi computer'in tum bilgilerini getiriniz
        Developer03 dev2 = session.get(Developer03.class,3);
        System.out.println(dev2.getComputer()); // uni-directional olsaydi computerden dev'e ulasamazdik

        //odev tum developer'larin ismini ve kullandiklari computer'in markasini yazdiriniz.
        //String hqlQuery = "SELECT d.name, c.brand FROM Developer03 d LEFT JOIN FETCH Computer c on d.id=d.computer.id";
        String hqlQuery = "SELECT d.name, c.brand FROM Developer03 d JOIN FETCH Computer c on c.id=d.computer.id";
        System.out.println("------------Homework----------");
        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();
        resultList.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        session.close();
        sf.close();
    }
}
