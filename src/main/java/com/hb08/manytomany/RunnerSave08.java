package com.hb08.manytomany;

import com.hb07.bi_onetomany.Student07;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 student1 = new Student08();
        student1.setId(1001);
        student1.setName("Melany");
        student1.setGrade(60);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Charly");
        student2.setGrade(80);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Jonny");
        student3.setGrade(75);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Chemistry Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("History Book");

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
    }
}
