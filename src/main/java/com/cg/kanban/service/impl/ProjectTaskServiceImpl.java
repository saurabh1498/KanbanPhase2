package com.cg.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.model.Project;
import com.cg.kanban.model.ProjectTask;

import com.cg.kanban.repository.ProjectTaskRepository;
import com.cg.kanban.service.ProjectTaskService;


@Service
public class ProjectTaskServiceImpl implements ProjectTaskService
{

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	@Override
	public ProjectTask addProjectTask( ProjectTask projectTask) {
		return this.projectTaskRepository.save(projectTask);
		
	}

	@Override
	public List<ProjectTask> getAllProjectTasks() {
		return this.projectTaskRepository.findAll();
		
	}

	@Override
	public ProjectTask getProjectTask(Integer id) {
		// TODO Auto-generated method stub
		return this.projectTaskRepository.findById(id).get();
	}

	@Override
	public void  deleteProjectTask(Integer id) {
		 this.projectTaskRepository.deleteById(id);
		
	}

	@Override
	public boolean isProjectTaskExist(Integer id) {
		// TODO Auto-generated method stub
		return this.projectTaskRepository.existsById(id);
	}
	
	public boolean isProjectTaskExist(String projectIdentifier) {
		// TODO Auto-generated method stub
		return this.projectTaskRepository.existsByProjectIdentifier(projectIdentifier);
	}

	public ProjectTask getProjectTask(String projectIdentfier) {
		// TODO Auto-generated method stub
		return this.projectTaskRepository.findByProjectIdentifier(projectIdentfier);
	}

}


