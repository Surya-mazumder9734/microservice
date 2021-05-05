package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.task;


@Repository
public interface TaskRepository extends JpaRepository<task, Long> {
    List<task> findByProjectId(Long projectId);
    Optional<task> findByIdAndProjectId(Long id, Long projectId);

}

