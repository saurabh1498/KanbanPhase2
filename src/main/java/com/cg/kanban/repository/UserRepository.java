package com.cg.kanban.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByloginname(String username);

	public boolean existsByloginname(String username);

}
