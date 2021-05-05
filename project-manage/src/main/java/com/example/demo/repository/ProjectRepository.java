package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.JoinDto;
import com.example.demo.model.project;



@Repository
public interface ProjectRepository extends JpaRepository<project, Long> {
List<project> findAll();

    @Query("SELECT new com.example.demo.dto.JoinDto(s.id, s.username,f.isCompleted, c.project_name, f.task_title) "
            + "FROM user s, task f,project c WHERE s.task.id = f.id AND f.project.id = c.id")
    List<JoinDto> fetchDataCrossJoin();
}
