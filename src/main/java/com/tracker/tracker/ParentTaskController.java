package com.tracker.tracker;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parent")
public class ParentTaskController {
	
	@Autowired
	ParentTaskService parentTaskService;

	@PostMapping("/tasks")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public Task createParentTask(@RequestBody Task task) {
			ParentTask parentTask = new ParentTask();
			parentTask.setParentTask(task.getTask());
			parentTask = parentTaskService.createParentTask(parentTask);
			task.setParentTask(parentTask);
			return task;
		
		
		
	}
}
