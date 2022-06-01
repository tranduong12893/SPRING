package com.fpt.hellospring.controller;

import com.fpt.hellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/api/V1/students      |   GET     | return list student
 * http://localhost:8080/api/V1/students      |   POST    | create new student
 * http://localhost:8080/api/V1/students/1    |   DELETE  | remove student
 * http://localhost:8080/api/V1/students/1    |   GET     | find student by id
 * http://localhost:8080/api/V1/students/1    |   PUT     | update student
 */


@RestController
@RequestMapping(path = "api/v1/students")
public class studentController {
    //CRUD
    private static List<Student> list;

    public studentController(){
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A001").fullName("Duong").build());
        list.add(Student.builder().rollNumber("A002").fullName("Thanh").build());
        list.add(Student.builder().rollNumber("A003").fullName("Dat").build());
        list.add(Student.builder().rollNumber("A004").fullName("Tien").build());
        list.add(Student.builder().rollNumber("A005").fullName("Hoang").build());

    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById( @PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student updateStudent){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return null;
        }
        Student exiting = list.get(foundIndex);
        exiting.setFullName(updateStudent.getFullName());
        return exiting;
    }
}
