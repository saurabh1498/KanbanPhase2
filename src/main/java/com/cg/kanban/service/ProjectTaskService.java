package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.model.ProjectTask;

public interface ProjectTaskService {
	public ProjectTask addProjectTask(ProjectTask projectTask);
	public List<ProjectTask> getAllProjectTasks();
	public ProjectTask getProjectTask(Integer Id);
	public void deleteProjectTask(Integer Id);
	public boolean isProjectTaskExist(Integer Id);

}
