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
	ParentTaskRepository parentTaskRepository;
	
	public TaskService (TaskRepository taskRepository, ParentTaskRepository parentTaskRepository) {
		this.taskRepository = taskRepository;
		this.parentTaskRepository = parentTaskRepository;
	}
	
		
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Long getAllProjectTasks(Long projectId){
		List<Task> taskList = taskRepository.findAllByProjectIdIn(projectId);
		return new Long(taskList.size());
	}
	
	
	public Page<Task> getAllTasksPage(int page){
		return taskRepository.findAll(new PageRequest(page, 4));
	}
	
	
	
	
	@Transactional
	public Task createTask(Task task) {	
			ParentTask parentTask = parentTaskRepository.getOne(task.getParentTask().getParentId());
			task.setParentTask(parentTask);
			//task.setProjectId(1L);
			//task.setStatus("Active");
			return taskRepository.save(task);
	
	}
	
	
	
	
	public Optional<Task> getTaskById(Long taskId) {
		return taskRepository.findById(taskId);
	}
	
	public Long getCompletedTaskStatistics(Long projectId) {
		return taskRepository.countAllByProjectIdInAndActiveIn(projectId, false);
	}
	
	
	public Task updateTask(Task updatedTask ){
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
