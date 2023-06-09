package com.practice01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer01.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Developer01 dev = session.get(Developer01.class,1);
        System.out.println(dev);

        //1-sql ile tum datayi cekiniz
        String sqlQuery1 = "SELECT * FROM t_developer01";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery1).getResultList();
        System.out.println("-----------SQL-----------");
        for (Object[] r:resultList){
            System.out.println(Arrays.toString(r));
        }

        //2-hql ile tum datayi cekiniz
        String hqlQuery1 = "FROM Developer01";
        List<Developer01> devList = session.createQuery(hqlQuery1,Developer01.class).getResultList();
        System.out.println("-----------HQL-----------");
        devList.forEach(t->System.out.println(t));

        // odev
        // 3-hql ile ismi 'Shrek' olan datayi cekiniz.
        String hqlQuery2 = "FROM Developer01 WHERE name='Shrek'";
        List<Developer01> devList3 = session.createQuery(hqlQuery2,Developer01.class).getResultList();
        System.out.println("-----------Homework3-----------");
        devList3.forEach(t->System.out.println(t));
        System.out.println(devList3);

        // 4-hql ile emali 'jack@gmail.com' olan datayi cekiniz.
        String hqlQuery3 = "FROM Developer01 WHERE email='jack@gmail.com'";
        System.out.println("-----------Homework4-----------");
        Developer01 dev3 = session.createQuery(hqlQuery3,Developer01.class).uniqueResult();
        System.out.println(dev3);

        // 5-hql ile branch i backend olan datanin ismini getiriniz.
        String hqlQuery4 = "SELECT d.name FROM Developer01 d WHERE branch='backend'";
        System.out.println("-----------Homework5-----------");
        List<String> nameList = session.createQuery(hqlQuery4,String.class).getResultList();
        nameList.forEach(t-> System.out.println(t));

        tx.commit(); // sadece fetch islemi yapacaksak, commit olmasa da olur
        session.close();
        sf.close();
    }
}
