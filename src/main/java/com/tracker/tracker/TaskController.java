package com.tracker.tracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}

	@GetMapping("/tasksgroup")
	@CrossOrigin(origins = "http://localhost:4200")
	public Page<Task> getAllTasksPage(@RequestParam(defaultValue="0") int page){
		return taskService.getAllTasksPage(page);
	}
	
	@PostMapping("/tasks")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public Task createTask(@RequestBody Task task) {
		
			return taskService.createTask(task);
		
		
		
	}
}
