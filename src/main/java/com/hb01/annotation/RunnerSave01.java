package com.hb01.annotation;

import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("John Lock");
        student1.setGrade(90);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
    }
}
