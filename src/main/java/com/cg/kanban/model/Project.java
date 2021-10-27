package com.cg.kanban.model;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
@Entity(name = "projects_tbl")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pid_Sequence")
    @SequenceGenerator(name = "pid_Sequence", sequenceName = "PID_SEQ",initialValue = 1, allocationSize = 1)
	@Column(name="project_id")
	private Integer id;
	@Column(name="project_name")
	private String projectName; 
	
	@Column(name="project_identifier",length = 30,unique = true)
	private String projectIdentifier;
	@Column(name="description")
	private String description;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Column(name="create_At", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;
	@Column(name="update_At")
    @UpdateTimestamp
    private LocalDateTime updateAt;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "backlog_id", referencedColumnName = "backlog_id")
	private Backlog backlog;
	
	public Project() {
		super();
	}



	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}







	public Backlog getBacklog() {
		return backlog;
	}







	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getProjectIdentifier() {
		return projectIdentifier;
	}



	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	



	public Project(Integer id, String projectName, String projectIdentifier, String description, LocalDate startDate,
			LocalDate endDate, LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectIdentifier = projectIdentifier;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createAt = createAt;
		this.updateAt = updateAt;
		
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public LocalDateTime getCreateAt() {
		return createAt;
	}






	public LocalDateTime getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}





}
