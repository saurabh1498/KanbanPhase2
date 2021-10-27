package com.cg.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.kanban.model.Project;
import com.cg.kanban.model.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer>{

	public ProjectTask findByProjectIdentifier(String project_identifier);

	public boolean existsByProjectIdentifier(String id);
}
