package com.cg.kanban.service;

import java.util.List;

import com.cg.kanban.model.Backlog;

public interface BacklogService {

	public Backlog addBacklog(Backlog backlog);
	public List<Backlog> getAllBacklogs();
	public Backlog getBacklog(Integer Id);
	public void deleteBacklog(Integer Id);
	public boolean isBacklogExist(Integer Id);

}
