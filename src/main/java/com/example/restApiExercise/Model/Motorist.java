package com.example.restApiExercise.Model;

import javax.persistence.*;

@Entity
//@Table(name = "motorist")
public class Motorist {
    @Id
    @GeneratedValue
    private int licence;
    private String firstname;
    private String lastname;
    private int age;
    @ManyToOne
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public int getLicence() {
        return licence;
    }

    public void setLicence(int licence) {
        this.licence = licence;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
