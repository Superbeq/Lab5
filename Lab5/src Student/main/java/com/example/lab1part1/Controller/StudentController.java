package com.example.lab1part1.Controller;

import com.example.lab1part1.ApiResponse.ApiResponse;
import com.example.lab1part1.Model.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    ArrayList<Students> students = new ArrayList<>();


    @GetMapping("name/{index}")
    public String getStudentName(@PathVariable int index){

        return students.get(index).getName();
    }



    @PutMapping("update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Students updatedStudents) {


        students.set(index, updatedStudents);

        return new ApiResponse("The student data has been deleted succesfully", "200");


    }



    @DeleteMapping("delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){

        students.remove(index);

        return  new ApiResponse("The user has been deleted succesfully", "200");
    }





    @GetMapping("age")

    public int getStudentAge(@PathVariable int index){


        return students.get(index).getAge();

    }

    @GetMapping("degree")

    public String getStudentDegree(@PathVariable int index){

        return students.get(index).getDegree();

    }


    @GetMapping("status/{index}")
    public ApiResponse getStatus(@PathVariable int index){

        if(students.get(index).getStudyStatus().equalsIgnoreCase("graduated")){

            return new ApiResponse("Gradauted", "True");

        } else {

            return new ApiResponse("Ungradauted", "False");

        }

    }



    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Students student){


        students.add(student);

        return new ApiResponse("Student is added", "200");

    }



}
