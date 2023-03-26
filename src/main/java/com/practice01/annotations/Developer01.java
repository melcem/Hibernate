package com.practice01.annotations;

import javax.persistence.*;

@Entity // pojo class a karsilik gelen tabloyu DB de olusturur
@Table(name="t_developer01") // optional, olmasaydi table_name=developer01
public class Developer01 {

    @Id // her bir entity icin zorunlu:PK saglar
    private int id;

    @Column(name="dev_name", length = 50, nullable = false) // optional
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

    // Constructor-without parameter: hibernate parametresiz constructor'i zorunlu tutuyor.
    public Developer01() {
    }

    // Constructor-with parameter

    public Developer01(int id, String name, String email, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    //!!! toString()
    @Override
    public String toString() {
        return "Developer01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
