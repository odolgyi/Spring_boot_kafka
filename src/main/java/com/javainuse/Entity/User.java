package com.javainuse.Entity;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobilePhone")
    private String mobilePhone;

    @Column(name = "adress")
    private String adress;

    public User(){}

    public User(String name, String mobilePhone, String adress) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + mobilePhone + " " + adress;
    }
}
