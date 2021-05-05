package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JoinDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.project;
import com.example.demo.repository.ProjectRepository;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository ;

    @GetMapping("")
    public String viewHomepage(){
        return  "index";
    }

    @GetMapping("/project/view")
    public List<project> getAllProject(project project) {
        return projectRepository.findAll();
    }

    @PostMapping(path="/project/add",consumes = "application/json")
    public project createProject( @RequestBody project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/project/{projectId}")
    public project updateProject(@PathVariable Long projectId,  @RequestBody project projectRequest) {
        return projectRepository.findById(projectId).map(project -> {
            project.setProject_name(projectRequest.getProject_name());
            project.setProject_manager(projectRequest.getProject_manager());
            project.setPriority(projectRequest.getPriority());
            return projectRepository.save(project);
        }).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
    }


    @DeleteMapping("/project/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectRepository.findById(projectId).map(project -> {
            projectRepository.delete(project);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
    }
    @GetMapping("/user/view")
    public ResponseEntity<List<JoinDto>> getLeftCrossData() {
        return new ResponseEntity<List<JoinDto>>(projectRepository.fetchDataCrossJoin(), HttpStatus.OK);
    }
}

