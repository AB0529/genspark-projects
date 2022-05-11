package com.ab0529.SpringJavaConfig.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("Student")
public class Student {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", add=" + add +
                '}';
    }
}
