package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;

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

    public String convertToJson(Pupil pupil) {
        JSONObject json = new JSONObject();
        try {
            json.put("id", pupil.getId());
            json.put("name", pupil.getName());
            json.put("gender", pupil.getGender());
            json.put("age", pupil.getAge());

            for (Grade grade : grades) {
                System.out.println(grade.getSubject());
                JSONObject jsonGrade;
                jsonGrade = grade.convertToJson();
                json.put("grades", jsonGrade);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonStr = json.toString();
        return jsonStr;
    }
}


