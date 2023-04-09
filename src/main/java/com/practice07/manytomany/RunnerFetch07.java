package com.practice07.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1) id'si 1 olan developer'in calistigi projeleri yazdiriniz.
        Developer07 dev1 = session.get(Developer07.class,1L);
        System.out.println(dev1.getProjects());

        //2) id'si 22 olan projede calisan dev'leri getiriniz.
        Project project = session.get(Project.class,22L);
        System.out.println(project.getDevelopers());

        tx.commit();
        session.close();
        sf.close();
    }
}
