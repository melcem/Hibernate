package com.practice08.idgeneration;

import javax.persistence.*;

@Entity
@Table(name="t_developer8")
public class Developer08 {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //id'nin uretilmesinden, otomatik olusturulmasindan tamamen DB sorumludur.
    @SequenceGenerator(name="sequence",sequenceName = "dev8_seq",initialValue = 100,allocationSize = 5)
    //allocationSize kadar id kumesi olusturulur, her insert icin Java uygulamasi, DB'ye siradaki sequence'in
    //ilk elemanini sorar.
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String branch;

    //Constructors

    public Developer08() {
    }

    public Developer08(String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    //Getter-Setter

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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

    //toString()

    @Override
    public String toString() {
        return "Developer08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
