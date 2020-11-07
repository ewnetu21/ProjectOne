package com.example.restApiExercise.security.jwt.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private  long id;
   @Enumerated(EnumType.STRING)
   @NaturalId
    private RoleName name;
    //@ManyToOne
    //private User user;
    public Role(){

    }
    public Role(RoleName name){
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
