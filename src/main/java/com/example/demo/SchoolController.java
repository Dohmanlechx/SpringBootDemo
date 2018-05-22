package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    School school = new School();

    // GET
    @RequestMapping(value = "/pupils", method = RequestMethod.GET)
    public List<Pupil> pupils(@RequestParam(value = "searchpupil", defaultValue = "") String searchPupil) {

        return school.getSearchedPupilsList(searchPupil);
    }

    // GET BY ID
    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.GET)
    public Pupil findPupil(@PathVariable("id") int pupilId) {
        return school.findPupil(pupilId);
    }

    // POST
    @RequestMapping(value = "/pupils", method = RequestMethod.POST)
    public Pupil postPupil(@RequestBody Pupil pupil) {

        school.addPupil(pupil);
        return pupil;
    }

    // DELETE
    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.DELETE)
    public void deletePupil(@PathVariable("id") int pupilId) {
        school.deletePupil(pupilId);
    }


}
