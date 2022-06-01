package com.fpt.hellospring.controller;

import com.fpt.hellospring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/hello")
public class helloController {

    @RequestMapping(path = "world", method = RequestMethod.GET)
    public String say(){ return "Hello World";}

    @RequestMapping(path = "talk", method = RequestMethod.GET)
    public String talk(){ return "Talk to World";}

    @RequestMapping(path = "student", method = RequestMethod.GET)
    public Student GetStudent(){
        return Student.builder()
                .rollNumber("A001")
                .fullName("Hong Xuan")
                .phone("0987456321")
                .address("Hanoi Vietnam")
                .dob(LocalDateTime.of(1993, 10, 12, 10, 10))
                .build();
    }
}
