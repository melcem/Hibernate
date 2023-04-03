package com.practice05.onetomany_uni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Objects;

public class RunnerFetch05{
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company05.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1) Amazon'da calisan developer bilgilerini getiriniz.
        String hql = "SELECT c.developers FROM Company05 c WHERE c.companyName='Amazon'";
        List<Object> resultList = session.createQuery(hql).getResultList();
        resultList.forEach(System.out::println);
        //company'den developer'a ulasabiliriz.

        //2) id'si 2 olan developer'i yazdirin
        Developer05 dev = session.get(Developer05.class,2L);
        System.out.println(dev);
        //developer'dan company bilgisine ulasamayiz, cunku tek yonlu iliski kurduk.

        tx.commit();
        session.close();
        sf.close();
    }
}
