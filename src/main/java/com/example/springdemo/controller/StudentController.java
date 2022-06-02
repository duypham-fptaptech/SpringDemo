package com.example.springdemo.controller;

import com.example.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    static List<Student> list = new ArrayList<>();
    {
        list.add(Student.builder().rollNumber("A001").fullName("duy").address("tb").dob(LocalDateTime.now()).build());
        list.add(Student.builder().rollNumber("A002").fullName("duy").address("tb").dob(LocalDateTime.now()).build());
        list.add(Student.builder().rollNumber("A001").fullName("duy").address("tb").dob(LocalDateTime.now()).build());
        list.add(Student.builder().rollNumber("A001").fullName("duy").address("tb").dob(LocalDateTime.now()).build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
     list.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, path = "id")
    public Student findById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "id")
    public Student update(@PathVariable String id, @RequestBody Student updateStudent){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
       Student existing = list.get(foundIndex);
        existing.setFullName(updateStudent.getFullName());
        existing.setAddress(updateStudent.getFullName());
        return existing;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "id")
    public boolean deleteById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }
}
