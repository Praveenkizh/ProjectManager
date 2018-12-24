package com.tracker.tracker;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public Project createProject(@RequestBody Project project) {
		
			return projectService.createProject(project);
		
		
		
	}
}


