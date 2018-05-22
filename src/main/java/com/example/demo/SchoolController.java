package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    //    private static final String template = "Hello, %s!";
    School school = new School();

    @RequestMapping(value = "/pupils", method = RequestMethod.GET)
//    @ResponseBody
    public List<Pupil> pupils(@RequestParam(value = "searchpupil", defaultValue = "") String searchPupil) {

        return school.getPupilsList(searchPupil);
    }

    @RequestMapping(value = "/pupils", method = RequestMethod.POST)
    public Pupil postPupil(@RequestBody Pupil pupil) {

        school.addPupil(pupil);
        return pupil;
    }

//    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.DELETE)
//    public Pupil deletePupil(@PathVariable String pupilId) {
//        school.deletePupil(pupilId);
//        return school.getPupilsList();
//    }

}
