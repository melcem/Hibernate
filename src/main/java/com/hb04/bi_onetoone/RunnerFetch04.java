package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // id'si belli olan student
        Student04 student = session.get(Student04.class,1001);

        // diary getir
        Diary04 diary = session.get(Diary04.class,101);

        System.out.println("-----------Student------------");
        System.out.println(student);
        System.out.println("------------Diary-------------");
        System.out.println(diary);
        System.out.println("------Diary uzerinden student objesi------");
        System.out.println(diary.getStudent());
        System.out.println("------Student uzerinden diary objesi------");
        System.out.println(student.getDiary());


        tx.commit();
        session.close();
        sf.close();

    }
}
