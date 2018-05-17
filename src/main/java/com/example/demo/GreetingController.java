package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {


    private static final String template = "Hello, %s!";
    School school = new School();

    @RequestMapping("/pupils")
    @ResponseBody
    public List<Pupil> pupils() {

        school.addMockData();

        return school.getPupilsList();
    }


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {

        return new Greeting(0, String.format(template, name)); // "Hello, " + name + "!"
    }

}
