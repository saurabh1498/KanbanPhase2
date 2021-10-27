package com.cg.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{

	public Project findByProjectIdentifier(String project_identifier);

	public boolean existsByProjectIdentifier(String id);

}
