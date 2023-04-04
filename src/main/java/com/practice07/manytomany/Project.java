package com.practice07.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)//iliski sahibi
    @JoinTable(name="project_developer",joinColumns = @JoinColumn(name="project_id"),
                                        inverseJoinColumns = @JoinColumn(name="dev_id"))
    private Set<Developer07> developers = new HashSet<>();

    //Constructors
    public Project() {
    }

    public Project(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    //Getter-Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Developer07> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer07> developers) {
        this.developers = developers;
    }

    //toString()

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
