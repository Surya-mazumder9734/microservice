package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class task  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="task_title")
    private String task_title;


    @Column(name = "owner_name")
    private String owner_name;

  
    @Column(name = "start_date")
    private Date start_date;

  
    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "isCompleted")
    private Boolean isCompleted;



//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "projectId", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("projetId")
    @ManyToOne(cascade=CascadeType.ALL)  
    private project project;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return task_title;
	}



	public void setTitle(String title) {
		this.task_title = title;
	}



	public String getOwner_name() {
		return owner_name;
	}



	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}



	public Date getStart_date() {
		return start_date;
	}



	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}



	public Date getEnd_date() {
		return end_date;
	}



	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}



	public Boolean getIsCompleted() {
		return isCompleted;
	}



	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}



	public project getProject() {
		return project;
	}



	public void setProject(project project) {
		this.project = project;
	}



	

   }

