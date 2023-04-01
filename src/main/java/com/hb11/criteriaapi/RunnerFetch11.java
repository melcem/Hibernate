package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

        tx.commit();
        session.close();
        sf.close();
    }
}
