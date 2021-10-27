package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.model.User;

public interface UserService {
	public User addUser(User user);
	public List<User> getAllUsers();
	public User getUser(Integer userId);
	public void deleteUser(Integer userId);
	public boolean isUserExist(Integer userId);

}





