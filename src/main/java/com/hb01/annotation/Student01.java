package com.hb01.annotation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // @Entity ile bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, student01(tablo adi otomatik)
@Table(name="t_student01") // (opsiyoneldir) DB de tablo isminin "t_student01" olarak degismesini saglar
public class Student01 {
    private int id;
    private String name;
    private int grade;

    public int getId() {
        return id;
    }

    // Getter-Setter
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

    // toString
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
