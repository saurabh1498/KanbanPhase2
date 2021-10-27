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
import com.cg.kanban.model.User;
import com.cg.kanban.service.impl.UserServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl service;
	
	

	@PostMapping("/")
	public ResponseEntity<?> add(@Valid @RequestBody User user, BindingResult br) throws ArgumentNotValidException
	{	
		if(br.hasErrors())
			
		{
			throw new ArgumentNotValidException("Enter Valid Data");
		}
		
		else if(user.getName().isEmpty())
		{
			return new ResponseEntity<String>("User Not added...Invalid Entry ",HttpStatus.BAD_REQUEST);
		}
	
		user=service.addUser(user);
		return new ResponseEntity<String>("User is added successfully ",HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("")
	public ResponseEntity<?>user() throws ResourceNotFoundException
	{
		List<User>userList=service.getAllUsers();
		if(userList.isEmpty())
		{
			throw new ResourceNotFoundException("Users not found");
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean userExist=service.isUserExist(id);
		if(userExist)
		{
			service.deleteUser(id);
			return new ResponseEntity<String>("User is deleted successfully", HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User with "+id+" not found");
		
	}
	
	
	


	@GetMapping("/{id}")
	public User getUser(@PathVariable("id")Integer id) throws ResourceNotFoundException
	{
		boolean userExist=service.isUserExist(id);
		if(userExist)
		{
			
			return this.service.getUser(id);
		}
		throw new ResourceNotFoundException("User with "+id+" not found");
		
	}
	@GetMapping("/loginname/{loginname}")
	public User getUser(@PathVariable("loginname")String loginname)
	{
	
			return this.service.getUserByUsername(loginname);
		
	}
	
	
	@GetMapping("/validateuser/{username}/{password}")
	public boolean validate(@PathVariable("username") String username,@PathVariable("password")String password)
	{
		boolean flag=service.validateUser(username, password);
		return flag;
	}
	
	
}
