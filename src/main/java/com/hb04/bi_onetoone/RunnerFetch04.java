package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        //!!! Task 1: Kesisim kumesini getirin (INNER JOIN)
        String hqlQuery = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d on s.id = d.student";
        List<Objects[]> resultList = session.createQuery(hqlQuery).getResultList();
        for (Object[] objects : resultList){
            System.out.println(Arrays.toString(objects));
        }

        // lambda expression ile yaz
        /*resultList.forEach(oa ->{
            System.out.println(Arrays.toString(oa));
        });*/

        // !!! Task 2: HQL LEFT JOIN
        String hqlQuery2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id = d.student";
        List<Objects[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
        for (Object[] objects : resultList2){
            System.out.println(Arrays.toString(objects));
        }

        // !!! Task 2: HQL RIGHT JOIN
        String hqlQuery3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d on s.id=d.student";
        List<Objects[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
        /*resultList3.forEach(oa ->{
            System.out.println(Arrays.toString(oa));
        });*/
        for (Object[] objects:resultList3){
            System.out.println(Arrays.toString(objects));
        }

        // !!! Task 2: HQL LEFT JOIN
        String hqlQuery4 = "SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary04 on s.id=d.student";


        tx.commit();
        session.close();
        sf.close();

    }
}
