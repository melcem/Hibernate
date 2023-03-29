package com.practice02.embeddable;

import com.practice01.annotations.Developer01;

import javax.persistence.*;

@Entity
@Table(name="t_developer2")
public class Developer02 {
    @Id // her bir entity icin zorunlu:PK saglar
    private int id;

    @Column(name="dev_name", length = 50, nullable = false) // optional
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

    @Embedded
    private Education education;

    public Developer02(){}

    public Developer02(int id, String name, String email, String branch, Education education) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.education = education;
    }

    //Getter-Setter

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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }


    //toString()

    @Override
    public String toString() {
        return "Developer02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", education=" + education +
                '}';
    }
}
