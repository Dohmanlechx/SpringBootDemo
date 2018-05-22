package com.example.demo;

import java.util.ArrayList;

public class Pupil {

    private int id;
    private String name;
    private String gender;
    private int age;
    private ArrayList<Grade> grades = new ArrayList<>();

    public Pupil() {
    }

    public Pupil(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Pupil(int id, String name, String gender, int age, ArrayList<Grade> grades) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public String convertToJson() {

    }
}


