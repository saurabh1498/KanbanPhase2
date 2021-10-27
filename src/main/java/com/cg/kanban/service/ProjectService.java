package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.model.Project;


public interface ProjectService{
	public Project addProject(Project Project);
	public List<Project> getAllProjects();
	public Project getProject(Integer Id);
	public void deleteProject(Integer Id);
	public boolean isProjectExist(Integer Id);

	public Project getProject(String projectIdentifier);
}
