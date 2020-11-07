package com.example.restApiExercise.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity

public class Vehicle extends AuditModel<Date>{
    @Id
    @GeneratedValue
    private int id;
    @Size(min=3)
    private String model;
    private String make;
    private String color;
    @ManyToOne
    private Accident accident;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id")
    private Set<Motorist> motorist;

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public Set<Motorist> getMotorist() {
        return motorist;
    }

    public void setMotorist(Set<Motorist> motorist) {
        this.motorist = motorist;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
