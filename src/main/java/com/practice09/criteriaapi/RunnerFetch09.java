package com.practice09.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer09.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1) Update the name of the developer with 1 to 'John Hopkins'.
        Developer09 dev1 = session.get(Developer09.class,1L);
        dev1.setName("John Hopkins");
        session.update(dev1);

        //2) Update the name of the developer with id 1 to 'Poet Henry Hopkins'.
        String hql1 = "UPDATE Developer09 d SET d.name='Poet Henry Hopkins' WHERE d.id=1";
        int numRecord = session.createQuery(hql1).executeUpdate();
        System.out.println("Number of Record: " +numRecord);

        //3) Set the salary of developers with less than $7000 salary to $7850 using the parameter.
        int updatedSalary = 7850;
        int checkSalary = 7000;
        String hql2 = "UPDATE Developer09 d SET d.salary=:updatedSalary WHERE d.salary<:checkSalary";
        int numOfRecord = session.createQuery(hql2).setParameter("updatedSalary",updatedSalary).
                                  setParameter("checkSalary",checkSalary).executeUpdate();
        System.out.println("Number Of Record: " + numOfRecord);

        tx.commit();
        session.close();
        sf.close();
    }
}
