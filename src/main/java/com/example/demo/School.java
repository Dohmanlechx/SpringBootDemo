package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class School {

    private static List<Pupil> pupilsList = new ArrayList<>();
    // Pre-written codes for the grades

    // Svenska
    private static final Grade svIG = new Grade("Svenska", "IG");
    private static final Grade svG = new Grade("Svenska", "G");
    private static final Grade svVG = new Grade("Svenska", "VG");
    private static final Grade svMVG = new Grade("Svenska", "MVG");
    // Matematik
    private static final Grade maIG = new Grade("Matematik", "IG");
    private static final Grade maG = new Grade("Matematik", "G");
    private static final Grade maVG = new Grade("Matematik", "VG");
    private static final Grade maMVG = new Grade("Matematik", "MVG");
    // Engelska
    private static final Grade engIG = new Grade("Engelska", "IG");
    private static final Grade engG = new Grade("Engelska", "G");
    private static final Grade engVG = new Grade("Engelska", "VG");
    private static final Grade engMVG = new Grade("Engelska", "MVG");

    public List<Pupil> getPupilsList() {
        return pupilsList;
    }

    public void addMockData() {

        // List of pupils

        Pupil p1 = new Pupil(100, "David", "Pojke", 12);
        p1.addGrade(svMVG);
        p1.addGrade(maVG);
        p1.addGrade(engG);
        pupilsList.add(p1);

        Pupil p2 = new Pupil(101, "Emma", "Flicka", 11);
        p2.addGrade(svG);
        p2.addGrade(maIG);
        p2.addGrade(engMVG);
        pupilsList.add(p2);

        Pupil p3 = new Pupil(102, "Dummer", "Pojke", 13);
        p3.addGrade(svIG);
        p3.addGrade(maIG);
        p3.addGrade(engIG);
        pupilsList.add(p3);

    }


}
