package com.practice06.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*//1) Amazon'da calisan developer bilgilerini yazdirin.
        //1. yontem
        String hql1 = "FROM Developer06 d WHERE d.company.companyName='Amazon'";
        List<Object> resultList1 = session.createQuery(hql1).getResultList();
        System.out.println("---------Amazon Workers----------");
        resultList1.forEach(System.out::println);
        //2. yontem
        String hql2 = "FROM Company06 c WHERE c.companyName='Amazon'";
        Company06 amazon = session.createQuery(hql2,Company06.class).uniqueResult();
        System.out.println("---------Amazon Workers----------");
        amazon.getDevelopers().forEach(System.out::println);
        //company'den dev'lere ulasabiliyoruz.*/

        /*//2) Email'i gandalf@gmail.com olan dev'in çalıştığı company bilgilerini getiriniz.
        String hql3 = "FROM Developer06 d WHERE d.email='gandalf@gmail.com'";
        Developer06 gandalf =  session.createQuery(hql3,Developer06.class).uniqueResult();
        System.out.println("---------gandalf----------");
        System.out.println(gandalf.getCompany());
        //developer'dan da company'e ulasabiliriz.*/

        //---------------DELETE-ORPHAN_REMOVAL-CASCADE_TYPE_ALL----------------
        /*//3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.
        Developer06 dev3 = session.get(Developer06.class,3L);
        Company06 company = session.get(Company06.class,22L);
        company.getDevelopers().remove(dev3);
        System.out.println("Amazon Workers: " +company.getDevelopers());
        //Orphanremoval true ise data'yi listeden(SET veya LIST) kaldirdigimizda/null'a set edersek tablodan siliyor.
        //CascadeTypeAll da listeden cikarilsa da tabloda duruyor.*/

        //4) id'si 22 olan company'i sil
        Company06 company22 = session.get(Company06.class,22L);
        session.delete(company22);
        //company iflas etti, dev'ler de gitti. Cascade Type All dedigimiz icin dev'ler silindi.


        tx.commit();
        session.close();
        sf.close();
    }
}
