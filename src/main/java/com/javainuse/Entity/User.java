package com.javainuse.Entity;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
@Data
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

    public User() {
    }

    public User(String name, String mobilePhone, String adress) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.adress = adress;
    }

    public String userDataToString() {
        return id + " " + name + " " + mobilePhone + " " + adress;
    }
}
