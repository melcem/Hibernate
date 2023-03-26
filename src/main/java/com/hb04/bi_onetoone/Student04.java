package com.hb04.bi_onetoone;

import com.hb03.uni_onetoone.Diary;

import javax.persistence.*;

@Entity
public class Student04 {

    @Id
    private int id;

    @Column(name="std_name")
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") //!!! sadece Diary tablosunda iliski icin yeni bir kolon olusmasini sagliyor
    private Diary diary;

    //!!! Getter - Setter

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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    //!!! toString()
    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }
}
