package com.hb07.bi_onetomany;

import javax.persistence.*;

@Entity
public class Book07 {
    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn // student_id
    private Student07 student;
}
