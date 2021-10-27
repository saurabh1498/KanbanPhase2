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
import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.ProjectTask;
import com.cg.kanban.model.Backlog;
import com.cg.kanban.service.impl.BacklogServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/backlogs")
public class BacklogController {




	@Autowired
	private BacklogServiceImpl service;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addBacklog(@Valid @RequestBody Backlog backlog, BindingResult br) throws ArgumentNotValidException
	{	
		if(br.hasErrors())
			
		{
			throw new ArgumentNotValidException("Enter Valid Data");
		}
		
		else if(backlog.getProjectIdentifier().isEmpty())
		{
			return new ResponseEntity<String>("Backlog Not added...Invalid Entry ",HttpStatus.BAD_REQUEST);
		}
	
		backlog=service.addBacklog(backlog);
		return new ResponseEntity<String>("Backlog is added successfully ",HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("")
	public ResponseEntity<?>getBacklog() throws ResourceNotFoundException
	{
		List<Backlog>backlogList=service.getAllBacklogs();
		if(backlogList.isEmpty())
		{
			throw new ResourceNotFoundException("Backlog not found");
		}
		return new ResponseEntity<List<Backlog>>(backlogList,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBacklog(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean BacklogExist=service.isBacklogExist(id);
		if(BacklogExist)
		{
			service.deleteBacklog(id);
			return new ResponseEntity<String>("Backlog deleted successfully", HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Backlog with "+id+" not found");
		
	}
	
	
	


	@GetMapping("/{id}")
	public Backlog getBacklog(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean BacklogExist=service.isBacklogExist(id);
		if(BacklogExist)
		{
			
			return this.service.getBacklog(id);
		}
		throw new ResourceNotFoundException("Backlog with "+id+" not found");
		
	}
	
	@GetMapping("/identifier/{identifier}")
	public Backlog getBacklogbyid(@PathVariable("identifier")String identifier) throws ResourceNotFoundException
	{
		boolean projectTaskExist=service.isBacklogExist(identifier);
		if(projectTaskExist)
		{
			
			return this.service.getBacklog(identifier);
		}
		throw new ResourceNotFoundException("project Task with "+identifier+" not found");
		
	}
	
	
}
