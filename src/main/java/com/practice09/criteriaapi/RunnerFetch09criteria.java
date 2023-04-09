package com.practice09.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch09criteria {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer09.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //----------------Criteria API-----------------
        //SQL ve HQL String bazli->hatay acik ve hatalri runtime'da gorebilir.
        //Criteria API, java kodlari ile programatik olarak sorgulama yapmamizi saglar.
        //Derleme aninda hatalari gorebilirz, hatalarin minimize edilmesini saglar.


        CriteriaBuilder cb =  session.getCriteriaBuilder();// CriteriaQuery nesnesi olusturmak ve bazi methodlarini kullanmak icin
        CriteriaQuery<Developer09> cq = cb.createQuery(Developer09.class);
        Root<Developer09> root = cq.from(Developer09.class);// bu class'in tum datalarini tutan bir kaynak

        //1) Get the developer named John.
        cq.select(root). // tum datayi getirir.
                where(cb.equal(root.get("name"),"John"));// where Predicate ister
        List<Developer09> resultList1 = session.createQuery(cq).getResultList();
        resultList1.forEach(System.out::println);

        //2) Get the developers whose salary is $8000.
        cq.select(root).where(cb.equal(root.get("salary"),8000));
        List<Developer09> resultList2 = session.createQuery(cq).getResultList();
        resultList2.forEach(System.out::println);

        //3) Get the developers whose salary is greater than $8000.
        cq.select(root).where(cb.greaterThan(root.get("salary"),8000));
        List<Developer09> resultList3 = session.createQuery(cq).getResultList();
        resultList3.forEach(System.out::println);

        //4) Get the developers whose name is Mick or whose salary is greater than $8000.
        Predicate predicate1 = cb.equal(root.get("name"),"Mick");
        Predicate predicate2 = cb.greaterThan(root.get("salary"),8000);
        cq.select(root).where(cb.or(predicate1,predicate2));

        tx.commit();
        session.close();
        sf.close();
    }
}
