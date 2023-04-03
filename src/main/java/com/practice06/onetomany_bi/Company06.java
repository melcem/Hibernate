package com.practice06.onetomany_bi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company06 {
    @Id
    private Long id;

    @Column(unique = true)
    private String companyName;

    //company'den calisan devleri gormek istiyoruz
    @OneToMany(mappedBy = "company")
    private Set<Developer06> developers = new HashSet<>();

    //Constructors

    public Company06() {
    }

    public Company06(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    //Getter-Setter
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

    public Set<Developer06> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer06> developers) {
        this.developers = developers;
    }

    //toString()
    @Override
    public String toString() {
        return "Company06{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
