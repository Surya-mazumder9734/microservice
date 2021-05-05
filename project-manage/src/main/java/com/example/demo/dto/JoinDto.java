package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JoinDto {
    private Long userId;
    private String username;
    private  boolean isCompleted;
    private  String project_name;
    private  String task_title;
	public JoinDto(Long userId, String username, boolean isCompleted, String project_name, String task_title) {
		super();
		this.userId = userId;
		this.username = username;
		this.isCompleted = isCompleted;
		this.project_name = project_name;
		this.task_title = task_title;
	}
	public JoinDto() {
		super();
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
    
}
