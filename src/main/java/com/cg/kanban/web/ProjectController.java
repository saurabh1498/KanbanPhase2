package com.cg.kanban.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.kanban.exception.ArgumentNotValidException;
import com.cg.kanban.exception.ResourceNotFoundException;
import com.cg.kanban.model.Project;

import com.cg.kanban.service.impl.ProjectServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/projects")
public class ProjectController {




	@Autowired
	private ProjectServiceImpl service;
	

	@PostMapping("/")
	public ResponseEntity<?> addProjects(@Valid @RequestBody Project project, BindingResult br) throws ArgumentNotValidException
	{	
		if(br.hasErrors())
			
		{
			throw new ArgumentNotValidException("Enter valid Data");
		}
		
		else if(project.getProjectIdentifier().isEmpty())
		{
			return new ResponseEntity<String>("project Not added...Invalid Entry ",HttpStatus.BAD_REQUEST);
		}
	
		project=service.addProject(project);
		return new ResponseEntity<String>("project is added successfully ",HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/")
	public ResponseEntity<?>getProjects() throws ResourceNotFoundException
	{
		List<Project>projectList=service.getAllProjects();
		if(projectList.isEmpty())
		{
			throw new ResourceNotFoundException("projects not found add new one");
		}
		return new ResponseEntity<List<Project>>(projectList,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteproject(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean projectExist=service.isProjectExist(id);
		if(projectExist)
		{ 	try {
			service.deleteProject(id);
			return new ResponseEntity<String>("project deleted successfully", HttpStatus.OK);}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		}
		throw new ResourceNotFoundException("project with "+id+" not found");
		
	}
	
	
	


	@GetMapping("/{id}")
	public Project getProject(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean projectExist=service.isProjectExist(id);
		if(projectExist)
		{
			
			return this.service.getProject(id);
		}
		throw new ResourceNotFoundException("project with "+id+" not found");
		
	}

	@GetMapping("/identifier/{identifier}")
	public Project getProjectbyid(@PathVariable("identifier")String identifier) throws ResourceNotFoundException
	{
		boolean projectExist=service.isProjectExist(identifier);
		if(projectExist)
		{
			
			return this.service.getProject(identifier);
		}
		throw new ResourceNotFoundException("project with "+identifier+" not found");
		
	}
	
	
	
	
}
