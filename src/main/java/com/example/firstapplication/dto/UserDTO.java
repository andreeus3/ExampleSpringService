package com.example.firstapplication.dto;


import java.time.LocalDate;

public class UserDTO {
    private long ID;

    private String name;
    private int age;
    private LocalDate dob;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public void setDob(LocalDate DOB) {
        this.dob = DOB;
    }
}
