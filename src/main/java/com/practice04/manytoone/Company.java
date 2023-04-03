package com.practice04.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    private Long id;

    @Column(unique = true)
    private String companyName;

    //Constructors
    public Company() {
    }

    public Company(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    // Getter - Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // toString()

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
