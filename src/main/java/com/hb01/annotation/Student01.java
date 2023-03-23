package com.hb01.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //!!! @Entity ile bu sinifin DB de bir tabbloya karsilik gelmesini sagliyoruz, student01
@Table(name="t_student01") //!!! DB de tablo isminin "t_student01" olarak degismesini sagladim
//Java kodu içinde bu class'a ulaşırken Student01 ile, SQL ile ulaşirken t_student01 ile yazmam lazım
public class Student01 {

    @Id // !!! primary-key olusmasini sagliyoruz
    //@Column(name="std_id")
    private int id;

    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;

    private int grade;

    // !!! GETTER - SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // !!! toString()

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}