package com.tracker.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ParentTaskService {
	
	
	private ParentTaskRepository parentTaskRepository;
	
	public ParentTaskService(ParentTaskRepository parentTaskRepository) {
		this.parentTaskRepository = parentTaskRepository;
	}
	
	public ParentTask createParentTask(ParentTask parentTask) {
		return this.parentTaskRepository.save(parentTask);
	}
	
	
}
