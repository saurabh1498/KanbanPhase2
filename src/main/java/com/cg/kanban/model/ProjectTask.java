package com.cg.kanban.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity(name = "tasks_tbl")
public class ProjectTask {
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ptid_Sequence")
    @SequenceGenerator(name = "ptid_Sequence", sequenceName = "PTID_SEQ",initialValue = 1, allocationSize = 1)
	@Column(name="task_id")
	private Integer id; 
	@Column(name="project_Sequence")
	private String projectSequence;
	@Column(name="summary")
	private String summary;
	@Column(name="acceptance_Criteria")
	private String acceptanceCriteria;
	@Column(name="status")
	private String status;
	@Column(name="priority")
	private String priority;
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	@Column(name="project_identifier",length = 30)
	private String projectIdentifier;
	@Column(name="create_At", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	@Column(name="update_At")
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	
	  @ManyToOne
	 @JoinColumn(name="backlog_id",referencedColumnName = "backlog_id")
	  private Backlog backlog;
	
	
	


	public ProjectTask() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getProjectSequence() {
		return projectSequence;
	}


	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}


	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public String getProjectIdentifier() {
		return projectIdentifier;
	}


	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}


	public LocalDateTime getCreateAt() {
		return createAt;
	}


	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}


	public LocalDateTime getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}


	public Backlog getBacklog() {
		return backlog;
	}
//
//
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}



	

}
