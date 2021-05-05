package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.task;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;

@RestController

public class TaskController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/project/{projectId}/task")
    public List<task> getAllTaskByProjectId(@PathVariable (value = "projectId") Long projectId
                                                ) {
        return taskRepository.findByProjectId(projectId);
    }

    @PostMapping("/project/{projectId}/task")
    public task createtask(@PathVariable (value = "projectId") Long projectId,
                                 @RequestBody task task) {
        return projectRepository.findById(projectId).map(project -> {
            task.setProject(project);
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
    }

   @PutMapping("/project/{projectId}/task/{taskId}")
    public task updateTask(@PathVariable (value = "projectId") Long projectId,
                                 @PathVariable (value = "taskId") Long taskId,
                                  @RequestBody task taskRequest) {
        if(!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("ProjectId " + projectId + " not found");
        }

        return taskRepository.findById(taskId).map(task -> {
            task.setTitle(taskRequest.getTitle());
            task.setStart_date(taskRequest.getStart_date());
            task.setEnd_date(taskRequest.getEnd_date());
            task.setOwner_name(taskRequest.getOwner_name());
            task.setIsCompleted(taskRequest.getIsCompleted());
            
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("taskId " + taskId + "not found"));
    }

    @DeleteMapping("/project/{projectId}/task/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable (value = "projectId") Long projectId,
                                           @PathVariable (value = "taskId") Long taskId) {
        return taskRepository.findByIdAndProjectId(taskId, projectId).map(task -> {
            taskRepository.delete(task);
            return ResponseEntity.ok().build();
 
}).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId + " and projectId " + projectId));
    }
}
