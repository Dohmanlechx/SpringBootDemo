package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {

    private List<Pupil> pupilsList;

    public School() {
        pupilsList = new ArrayList<>();

        readFromTextFile();
    }

    public void readFromTextFile() {
        try {
            Scanner scanner = new Scanner(new FileReader("storage.txt"));
            String str = scanner.next();

            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Pupil> getPupilsList() {
        return pupilsList;
    }

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

    public List<Pupil> getSearchedPupilsList(String searchPupil) {
        if (searchPupil == "") {
            return pupilsList;
        }

        ArrayList<Pupil> searchedPupil = new ArrayList<>();
        for (Pupil pupil : pupilsList) {
            if (pupil.getName().toLowerCase().contains(searchPupil.toLowerCase())) {
                searchedPupil.add(pupil);
            }
        }

        return searchedPupil;
    }

    public Pupil findPupil(int pupilId) {
        for (Pupil pupil : pupilsList) {
            if (pupil.getId() == pupilId) {
                return pupil;
            }
        }

        return null;
    }

    public void addPupil(Pupil newPupil) {
        pupilsList.add(newPupil);
    }

    public void deletePupil(int pupilId) {
        for (Pupil pupil : pupilsList) {
            if (pupil.getId() == pupilId) {
                pupilsList.remove(pupil);
            }
        }
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
        p2.addGrade(maG);
        p2.addGrade(engMVG);
        pupilsList.add(p2);

        Pupil p3 = new Pupil(102, "Dummer", "Pojke", 13);
        p3.addGrade(svIG);
        p3.addGrade(maIG);
        p3.addGrade(engIG);
        pupilsList.add(p3);

        Pupil p4 = new Pupil(103, "Kalle", "Pojke", 10);
        p4.addGrade(svVG);
        p4.addGrade(maMVG);
        p4.addGrade(engVG);
        pupilsList.add(p4);

        Pupil p5 = new Pupil(104, "Kristina", "Flicka", 9);
        p5.addGrade(svG);
        p5.addGrade(maMVG);
        p5.addGrade(engIG);
        pupilsList.add(p5);

        // Creating a text file for the permanent storing
        String fileName = "storage.txt";

        try {
            PrintWriter writer = new PrintWriter(fileName);

            JSONArray pupilArray = new JSONArray();

            for (Pupil pupil : pupilsList) {
                pupilArray.put(pupil.convertToJson());
            }
            writer.println(pupilArray.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}