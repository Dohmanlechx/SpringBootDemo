package com.example.demo;

import org.json.JSONArray;
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

            JSONObject jsonGrade;

            JSONArray jsonArrayGrades = new JSONArray();
            for (Grade grade : grades) {
                jsonGrade = grade.convertToJson();
                jsonArrayGrades.put(jsonGrade);
            }

            json.put("grades", jsonArrayGrades);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonStr = json.toString();
        return jsonStr;
    }
}


