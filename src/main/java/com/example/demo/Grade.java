package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

public class Grade {

    private String subject, grade;

    public Grade() {
    }

    public Grade(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    public JSONObject convertToJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("subject", subject);
            json.put("grade", grade);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}
