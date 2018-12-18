package com.tracker.tracker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TaskService {
	
	TaskRepository taskRepository;
	public TaskService (TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
		
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	
	public Page<Task> getAllTasksPage(int page){
		return taskRepository.findAll(new PageRequest(page, 4));
	}
	
	
	@Transactional
	public Task createTask(Task task) {		
			return taskRepository.save(task);
	
	}
	
	
	
	
	public Optional<Task> getTaskById(Long taskId) {
		return taskRepository.findById(taskId);
	}
	
	
	public Task updateTask(Long taskId, Task updatedTask ){
		return taskRepository.save(updatedTask);
		
	}
	
	
	public Task deleteTask(Long taskId, Task updatedTask ){
		Optional<Task> task = taskRepository.findById(taskId);
		if(task.isPresent()) {
			taskRepository.delete(updatedTask);
		}
		return updatedTask;
	}
}
