package com.cg.kanban.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name ="backlogs_tbl")
public class Backlog {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "bid_Sequence")
    @SequenceGenerator(name = "bid_Sequence", sequenceName = "BID_SEQ",initialValue = 1, allocationSize = 1)
	@Column(name="backlog_id")
	private Integer id; 
	@Column(name="pT_Sequence",length = 30)
	private String pTSequence;
	
	@Column(name="project_identifier",length = 30)
	private String projectIdentifier;

	@OneToOne(mappedBy = "backlog")
    private Project project;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProjectTask> ProjectTasks = new ArrayList<ProjectTask>();
	
	public Backlog() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getpTSequence() {
		return pTSequence;
	}

	public void setpTSequence(String pTSequence) {
		this.pTSequence = pTSequence;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

//	public List<ProjectTask> getProjectTasks() {
//		return ProjectTasks;
//	}

	public void setProjectTasks(List<ProjectTask> projectTasks) {
		ProjectTasks = projectTasks;
	}

//	public Project getProject() {
//		return project;
//	}

	
	
	
	
}
