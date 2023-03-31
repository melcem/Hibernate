package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!! get
        Student07 student = session.get(Student07.class,1001);
        System.out.println(student);

        /*//!!! SQL ile ogrenci bilgilerini(Inner Join) alalim (ogrenci ismi ve kitap ismi)
        String sqlQuery = "SELECT s.student_name, b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
        System.out.println("------------Homework-1------------");
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
        for(Object[] object:resultList1){
            System.out.println(Arrays.toString(object));
        }*/

       /* //!!! HQL ile ogrenci bilgilerini(Inner Join) alalim (ogrenci ismi ve kitap ismi)
        String hqlQuery =
                "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
        resultList2.forEach(oa -> System.out.println(Arrays.toString(oa)));*/

        /*//!!! Delete islemi SQL
        String sqlQuery1 = "DELETE FROM book07";
        int numOfDeletedRecords = session.createSQLQuery(sqlQuery1).executeUpdate();
        System.out.println("Number of deleted record: "+numOfDeletedRecords);*/

        /*String hqlQuery2 = "DELETE FROM student07";
        int numOfDeletedRecords2 = session.createSQLQuery(hqlQuery2).executeUpdate();
        System.out.println("Number of deleted record: "+numOfDeletedRecords2);*/

        /*//!!! Delete islemi HQL
        String sqlQuery3 = "DELETE FROM Book07";
        int numOfDeletedRecords3 = session.createQuery(sqlQuery3).executeUpdate();
        System.out.println("Number of deleted record: "+numOfDeletedRecords3);*/

        /*String hqlQuery4 = "DELETE FROM Student07";
        int numOfDeletedRecords4 = session.createQuery(hqlQuery4).executeUpdate();
        System.out.println("Number of deleted record: "+numOfDeletedRecords4);*/

        //!!! Kitap ismi A Book olan kitabi HQL ile siliniz
        String sqlQuery5 = "DELETE FROM Book07 b WHERE b.name='A Book'";
        int numOfDeletedRecords5 = session.createQuery(sqlQuery5).executeUpdate();
        System.out.println("Number of deleted record: "+numOfDeletedRecords5);

        // !!! Kitab bilgisi olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir
        // 2.yol ) Student classina Cascade / orphanRemoval

        /*//!!! 1001 id'li student objemi delete metodu ile sil
        Student07 student2 = session.get(Student07.class,1001);
        session.delete(student2);*/

        //student2.getBook07List().set(0, null); // 101 , 102 --> null , 102

        //!!! book ismi icinde "Book" gecen student kayitlarini al(HQL)
        String hqlQuery4 = "SELECT s FROM Student07 s JOIN s.bookList b WHERE b.name LIKE '%Book%'";
        List<Student07> resultList4 = session.createQuery(hqlQuery4,Student07.class).getResultList();
        for(Student07 student07 : resultList4){
            System.out.println(student07);
        }


        tx.commit();
        session.close();
        sf.close();
    }
}
