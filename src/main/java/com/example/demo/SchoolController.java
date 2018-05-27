package com.example.demo;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

@RestController
public class SchoolController {

    School school;

    // GET
    @RequestMapping(value = "/pupils", method = RequestMethod.GET)
    public List<Pupil> pupils(@RequestParam(value = "searchpupil", defaultValue = "") String searchPupil) {
        readFromTextFile();
        return school.getSearchedPupilsList(searchPupil);
    }

    // GET BY ID
    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.GET)
    public Pupil findPupil(@PathVariable("id") int pupilId) {
        readFromTextFile();
        return school.findPupil(pupilId);
    }

    // POST
    @RequestMapping(value = "/pupils", method = RequestMethod.POST)
    public Pupil postPupil(@RequestBody Pupil pupil) {
        readFromTextFile();
        school.addPupil(pupil);
        realTimeStorage();
        return pupil;
    }

    // DELETE
    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.DELETE)
    public void deletePupil(@PathVariable("id") int pupilId) {
        readFromTextFile();
        school.deletePupil(pupilId);
        realTimeStorage();
    }

    private void readFromTextFile() {
        try {
            Reader reader = new FileReader("storage.txt");
            Gson gson = new Gson();
            school = gson.fromJson(reader, School.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void realTimeStorage() {
        // Creating a text file for the permanent storing
        String fileName = "storage.txt";

        try {
            PrintWriter writer = new PrintWriter(fileName);

            JSONObject pupilsList = new JSONObject();
            JSONArray pupilArray = new JSONArray();

            for (Pupil pupil : school.getPupilsList()) {
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
