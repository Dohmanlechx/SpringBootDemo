package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

//    private static final String template = "Hello, %s!";
    School school = new School();

    @RequestMapping(value="/pupils", method = RequestMethod.GET)
//    @ResponseBody
    public List<Pupil> pupils(@RequestParam(value="searchpupil", defaultValue = "") String searchPupil) {

        return school.getPupilsList(searchPupil);
    }

    @RequestMapping(method=RequestMethod.POST, value="/pupils")
    public void addPupil(@RequestBody Pupil pupil) {

    }

}
