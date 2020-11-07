package com.example.restApiExercise.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Accident extends AuditModel<Date>{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accident_id",referencedColumnName = "id")
    private Set<Vehicle> vehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
