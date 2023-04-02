package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {
        /*
            CRUD (Create, Read, Update, Delete)

              C --> Sesion.save
              R --> Session.get, HQL, SQL
              U --> Session.update, updateQuery
              D --> session.delete, HQL, SQL
         */

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // update process
        Student11 student = session.get(Student11.class,1L);
        student.setName("Updated " + student.getName());
        session.update(student);

        /*//!!! Degisken tanimla
        // MathGrade puani 30'dan kucuk olan ogrencilerin puanlarini 80 yapalim
        int sMathGrade = 80;
        int lMathGrade = 30;

        String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
        Query query = session.createQuery(hqlQuery);

        query.setParameter("sMath",sMathGrade);
        query.setParameter("lMath",lMathGrade);

        int numOfRecords = query.executeUpdate();
        System.out.println("Degistirilen Kayit Sayisi: " +numOfRecords);*/

        // !!! CriteriaAPI ***************************************
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

        /*criteriaQuery.select(root);
        Query query1 = session.createQuery(criteriaQuery);
        List<Student11> resulList = query1.getResultList();
        resulList.forEach(System.out::println);*/

        //!!! 2.Örnek , Student ismi "Student Name 6" olan öğrenci bilgilerini getirelim\
        /*criteriaQuery.select(root). // SELECT * FROM Student11
                where(cb.equal(root.get("name"), "Student Name 6"));
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query2.getResultList();
        resultList2.forEach(System.out::println);*/

        //!!!  3.Örnek, mathGrade değeri 80 den büyük olan dataları getirelim
       /* criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
        Query<Student11> query3 = session.createQuery(criteriaQuery);
        List<Student11> resulList3 = query3.getResultList();
        resulList3.forEach(System.out::println);*/

        //!!! 4.Örnek MathGrade değeri 95 den küçük olan datalar
        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),95));
        Query query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList4 = query4.getResultList();
        resultList4.forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();
    }
}
