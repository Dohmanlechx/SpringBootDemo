package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class School {

    private List<Pupil> pupilsList;

    public School() {
        //TODO, NEVER RUN THIS CODE! ONLY FOR DEVELOPER!
//        addMockData();
    }

    public List<Pupil> getPupilsList() {
        return pupilsList;
    }

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
        for (Iterator<Pupil> it = pupilsList.iterator(); it.hasNext();) {
            Pupil pupil = it.next();
            if (pupil.getId() == pupilId) {
                it.remove();
            }
        }
    }

    public void addMockData() {

        // Pre-written codes for the grades

        // Svenska
        final Grade svIG = new Grade("Svenska", "IG");
        final Grade svG = new Grade("Svenska", "G");
        final Grade svVG = new Grade("Svenska", "VG");
        final Grade svMVG = new Grade("Svenska", "MVG");
        // Matematik
        final Grade maIG = new Grade("Matematik", "IG");
        final Grade maG = new Grade("Matematik", "G");
        final Grade maVG = new Grade("Matematik", "VG");
        final Grade maMVG = new Grade("Matematik", "MVG");
        // Engelska
        final Grade engIG = new Grade("Engelska", "IG");
        final Grade engG = new Grade("Engelska", "G");
        final Grade engVG = new Grade("Engelska", "VG");
        final Grade engMVG = new Grade("Engelska", "MVG");

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

            JSONObject pupilsList = new JSONObject();
            JSONArray pupilArray = new JSONArray();

            for (Pupil pupil : getPupilsList()) {
                pupilArray.put(pupil.convertToJson());
            }
            pupilsList.put("pupilsList", pupilArray);
            writer.println(pupilsList.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}