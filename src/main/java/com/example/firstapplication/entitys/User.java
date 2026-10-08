package com.example.firstapplication.entitys;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="USERS")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;
    private int age;
    private LocalDate dob;
    private String password;

    public User(){

    }

    public User(String name, int age, LocalDate dob, String password){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate DOB) {
        this.dob = DOB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
