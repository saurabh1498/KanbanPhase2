package com.cg.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.kanban.exception.ResourceNotFoundException;
import com.cg.kanban.model.ProjectTask;
import com.cg.kanban.model.User;
import com.cg.kanban.repository.UserRepository;
import com.cg.kanban.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User addUser( User user) {
		return this.userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
		
	}

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId).get();
	}

	@Override
	public void  deleteUser(Integer userId) {
		
		this.userRepository.deleteById(userId);	
	}
	
	public User getUserByUsername(String loginname) {
		// TODO Auto-generated method stub
		return this.userRepository.findByloginname(loginname);
	}


	@Override
	public boolean isUserExist(Integer userId) {
		// TODO Auto-generated method stub
		return this.userRepository.existsById(userId);
	}
	
	public boolean isUserExistByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.existsByloginname(username);
	}
	
	public boolean validateUser(String username,String password)
	{
		List<User>users=userRepository.findAll();
		for(User usr:users) 
		{
			if(((usr.getLoginname().equalsIgnoreCase(username)) &&usr.getPassword().equals(password)))
			{
				return true;
			}
		}return false;
	}



}
