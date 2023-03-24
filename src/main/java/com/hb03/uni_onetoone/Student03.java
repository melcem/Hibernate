package com.hb03.uni_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student03 {

    @Id
    private int id;

    @Column(name="sdt_name")
    private String name;

    private int grade;
}
