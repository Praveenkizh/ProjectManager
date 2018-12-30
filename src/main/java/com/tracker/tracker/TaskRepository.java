package com.tracker.tracker;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	public List<Task> findAllByProjectIdIn(Long projectId);
	
	public Long countAllByProjectIdInAndActiveIn(Long projectId, boolean active);
	


}
