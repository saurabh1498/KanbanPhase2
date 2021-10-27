package com.cg.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.Project;
@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Integer> {
	public Backlog findByProjectIdentifier(String project_identifier);

	public boolean existsByProjectIdentifier(String id);
}
