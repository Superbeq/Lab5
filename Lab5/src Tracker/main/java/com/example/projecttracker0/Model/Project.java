package com.example.projecttracker0.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {


    private int id;

    private String title;

    private String description;

    private String status;

    private String company_name;

}