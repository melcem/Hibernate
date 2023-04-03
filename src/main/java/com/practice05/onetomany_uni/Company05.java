package com.practice05.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company05 {
    @Id
    private Long id;

    @Column(unique = true)
    private String companyName;

    //company'de calisan dev'leri gormek istiyoruz.
    @OneToMany
    //join column kullanmazsak join table uretilir.
    @JoinColumn(name="company_id")//developer tablosunda bir fk sutunu olustur.
    private Set<Developer05> developers = new HashSet<>();

    //Constructors

    public Company05() {
    }

    public Company05(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    //Getter - Setter

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

    public Set<Developer05> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer05> developers) {
        this.developers = developers;
    }


    //toString()

    @Override
    public String toString() {
        return "Company05{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", developers=" + developers +
                '}';
    }
}
