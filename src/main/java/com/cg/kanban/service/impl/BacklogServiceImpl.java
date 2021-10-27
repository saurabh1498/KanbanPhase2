package com.cg.kanban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.ProjectTask;
import com.cg.kanban.repository.BacklogRepository;
import com.cg.kanban.service.BacklogService;

@Service
public class BacklogServiceImpl implements BacklogService
{

	@Autowired
	private BacklogRepository backlogRepository;
	@Override
	public Backlog addBacklog( Backlog backlog) {
		return this.backlogRepository.save(backlog);
		
	}

	@Override
	public List<Backlog> getAllBacklogs() {
		return this.backlogRepository.findAll();
		
	}

	@Override
	public Backlog getBacklog(Integer id) {
		// TODO Auto-generated method stub
		return this.backlogRepository.findById(id).get();
	}

	@Override
	public void  deleteBacklog(Integer id) {
		 this.backlogRepository.deleteById(id);
		
	}

	@Override
	public boolean isBacklogExist(Integer id) {
		// TODO Auto-generated method stub
		return this.backlogRepository.existsById(id);
	}

	public boolean isBacklogExist(String projectIdentifier) {
		// TODO Auto-generated method stub
		return this.backlogRepository.existsByProjectIdentifier(projectIdentifier);
	}

	public Backlog getBacklog(String projectIdentfier) {
		// TODO Auto-generated method stub
		return this.backlogRepository.findByProjectIdentifier(projectIdentfier);
	}
	
}

