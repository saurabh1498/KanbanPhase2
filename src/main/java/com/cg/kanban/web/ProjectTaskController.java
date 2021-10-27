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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.kanban.exception.ArgumentNotValidException;
import com.cg.kanban.exception.ResourceNotFoundException;
import com.cg.kanban.model.Project;
import com.cg.kanban.model.ProjectTask;

import com.cg.kanban.service.impl.ProjectTaskServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/projecttasks")
public class ProjectTaskController {




	@Autowired
	private ProjectTaskServiceImpl service;
	
	

	@PostMapping("/")
	public ResponseEntity<?> addProjectTasks(@Valid @RequestBody ProjectTask projectTask, BindingResult br) throws ArgumentNotValidException
	{	
		if(br.hasErrors())
			
		{
			throw new ArgumentNotValidException("Enter Valid Data");
		}
		
		else if(projectTask.getProjectIdentifier().isEmpty())
		{
			return new ResponseEntity<String>("ProjectTask Not added...Invalid Entry ",HttpStatus.BAD_REQUEST);
		}
	
		projectTask=service.addProjectTask(projectTask);
		return new ResponseEntity<String>("ProjectTask is added successfully ",HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("")
	public ResponseEntity<?>getProjectTasks() throws ResourceNotFoundException
	{
		List<ProjectTask>ProjectTaskList=service.getAllProjectTasks();
		if(ProjectTaskList.isEmpty())
		{
			throw new ResourceNotFoundException("ProjectTasks not found");
		}
		return new ResponseEntity<List<ProjectTask>>(ProjectTaskList,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProjectTask(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean projectTaskExist=service.isProjectTaskExist(id);
		if(projectTaskExist)
		{
			service.deleteProjectTask(id);
			return new ResponseEntity<String>("Project Task deleted successfully", HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Project Task with "+id+" not found");
		
	}
	
	@GetMapping("/identifier/{identifier}")
	public ProjectTask getProjectTaskbyid(@PathVariable("identifier")String identifier) throws ResourceNotFoundException
	{
		boolean projectTaskExist=service.isProjectTaskExist(identifier);
		if(projectTaskExist)
		{
			
			return this.service.getProjectTask(identifier);
		}
		throw new ResourceNotFoundException("project Task with "+identifier+" not found");
		
	}
	
	
	
	


	@GetMapping("/{id}")
	public ProjectTask getProjectTask(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean projectTaskExist=service.isProjectTaskExist(id);
		if(projectTaskExist)
		{
			
			return this.service.getProjectTask(id);
		}
		throw new ResourceNotFoundException("ProjectTask with "+id+" not found");
		
	}
	
	
	
	
	
}

