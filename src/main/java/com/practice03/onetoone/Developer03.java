package com.practice03.onetoone;

import javax.persistence.*;

@Entity
public class Developer03 {
    @Id
    private int id;

    @Column(name="dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    //her developer'a bir bilgisayar veriliyor ve bu bilgi tutulmak istiyor

    @OneToOne
    @JoinColumn(name="c_name")
    private Computer computer;
}
