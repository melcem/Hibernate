package com.practice04.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1) id'si 2 olan developer'in calistigi company bilgilerini yazdiriniz.
        Developer04 dev1 = session.get(Developer04.class,2L);
        System.out.println("--------------1----------------");
        System.out.println(dev1);
        System.out.println(dev1.getCompany());
        //developer'dan company bilgisine ulasabiliriz.

        //2) id'si 11 olan company bilgilerini yazdiriniz.
        Company company1 = session.get(Company.class,11L);
        System.out.println("--------------2----------------");
        System.out.println(company1);
        //company'den dev bilgilerine ulasamiyoruz, cunku tek yonlu iliski var.

        //3) tum developer'larin ismini ve calistiklari company ismini yazdiriniz.
        String sql = "SELECT d.dev_name, c.companyName.name FROM t_developer04 d JOIN company c d.company_id=c_id";
        List<Object[]> resultList = session.createQuery(sql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        tx.commit();
        session.close();
        sf.close();
    }
}
