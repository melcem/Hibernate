package com.practice02.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Education {
    private String university;

    private String department;

    public Education(){}

    //!!! Constructor
    public Education(String university, String department) {
        this.university = university;
        this.department = department;
    }

    //!!! Getter-Setter
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //!!! toString()

    @Override
    public String toString() {
        return  "university='" + university + '\'' +
                ", department='" + department + '\'';
    }
}
