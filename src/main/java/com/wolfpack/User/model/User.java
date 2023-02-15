package com.wolfpack.User.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    //PARAMETERS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String first;
    @Column
    private String last;
    @Column
    private String email;
    @Column
    private List<Object> workout;

    //CONSTRUCTORS
    public User() {}
    public User(String first, String last, String email) {
        this.first = first;
        this.last = last;
    }

    //METHOD
    public int getId() {
        return this.id;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getFirst() {
        return this.first;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getLast() {
        return this.last;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void setWorkout(List workout) {
        this.workout = workout;
    }
    public List getWorkout() {
        return this.workout;
    }
}
