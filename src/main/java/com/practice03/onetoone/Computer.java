package com.practice03.onetoone;

import javax.persistence.*;

@Entity
@Table(name="t_computer")
public class Computer { //PK
    @Id
    private int id;

    @Column(length = 8)
    private String serialNo;

    private String brand;

    @OneToOne(mappedBy = "computer") //computer tablosunda FK olusmaz
    private Developer03 developer;

    //Constructor
    public Computer(){}
    public Computer(int id, String serialNo, String brand) {
        this.id = id;
        this.serialNo = serialNo;
        this.brand = brand;
    }

    //Getter-Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Developer03 getDeveloper() { return developer;  }

    public void setDeveloper(Developer03 developer) {
        this.developer = developer;
    }

    //toString()

    @Override //developer degiskenini de yazdirirsak StackOverFlow
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", serialNo='" + serialNo + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
