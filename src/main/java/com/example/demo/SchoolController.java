package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {


    private static final String template = "Hello, %s!";
    School school = new School();

    @RequestMapping("/pupils")
    @ResponseBody
    public List<Pupil> pupils() {

        school.addMockData();

        return school.getPupilsList();
    }

    @RequestMapping(method=RequestMethod.POST, value="/pupils")
    public void addPupil(@RequestBody Pupil pupil) {

    }

}
