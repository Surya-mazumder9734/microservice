package com.example.demo.model;

import com.example.demo.model.*;
import javax.persistence.*;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "user")
public class user  implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @Column(name = "username")
	 private String username;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private task task;


	

}
