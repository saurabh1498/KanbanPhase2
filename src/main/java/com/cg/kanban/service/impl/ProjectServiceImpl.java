package com.cg.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.model.Project;
import com.cg.kanban.repository.ProjectRepository;
import com.cg.kanban.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService
{

	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public Project addProject( Project project) {
		return this.projectRepository.save(project);
		
	}
	
	
	

	@Override
	public List<Project> getAllProjects() {
		return this.projectRepository.findAll();
		
	}

	@Override
	public Project getProject(Integer id) {
		// TODO Auto-generated method stub
		return this.projectRepository.findById(id).get();
	}

	@Override
	public void  deleteProject(Integer id) {
		 this.projectRepository.deleteById(id);
		
	}

	@Override
	public boolean isProjectExist(Integer id) {
		// TODO Auto-generated method stub
		return this.projectRepository.existsById(id);
	}
	public boolean isProjectExist(String projectIdentifier) {
		// TODO Auto-generated method stub
		return this.projectRepository.existsByProjectIdentifier(projectIdentifier);
	}




	@Override
	public Project getProject(String projectIdentfier) {
		// TODO Auto-generated method stub
		return this.projectRepository.findByProjectIdentifier(projectIdentfier);
	}

}
