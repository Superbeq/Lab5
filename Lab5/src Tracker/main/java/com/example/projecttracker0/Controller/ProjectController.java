package com.example.projecttracker0.Controller;


import com.example.projecttracker0.ApiResponse.ApiResponse;
import com.example.projecttracker0.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/project-tracker")
public class ProjectController {



    ArrayList<Project> projects = new ArrayList<>();


    @PostMapping("create")
    public ApiResponse createProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project created successfully", "201");
    }


    @GetMapping("get/projects")
    public ArrayList<Project> getProjects() {

        return projects;

    }


    @PutMapping("update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project){

        projects.set(index, project);

        return new ApiResponse("The project is updated succesfully", "200");
    }


    @DeleteMapping("delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){

        projects.remove(index);

        return new ApiResponse("Project has been deleted succesfully", "200");
    }

    @PutMapping("modify/status/{index}")
    public ApiResponse modifyStatus(@PathVariable int index, String status){

        if(projects.get(index).getStatus().equalsIgnoreCase("not done"))
        {
            projects.get(index).setStatus("done");

        }

        return new ApiResponse("The status is modified", "200");

    }

    @GetMapping("/search/{title}")
    public ArrayList<Project> searchProject(@PathVariable String title) {

        ArrayList<Project> searched = new ArrayList<>();

        for(Project project : projects) {

            if(project.getTitle().equalsIgnoreCase(title))
            {
                searched.add(project);
            }
        }
        return searched;
    }

    @GetMapping("/get/{companyName}")
    public ArrayList<Project> getProjectsByCompanyName(@PathVariable String companyName )
    {
        ArrayList<Project> searched= new ArrayList<>();

        for(Project project : projects) {
            if(project.getCompany_name().equalsIgnoreCase(companyName)) {
                searched.add(project);
            }

        }
        return searched;

    }


}
