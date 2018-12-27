package com.tracker.tracker;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectService {
	private ProjectRepository projectRepository;
	private TaskService taskService;
	
	public ProjectService(ProjectRepository projectRepository, TaskService taskService) {
		this.projectRepository = projectRepository;
		this.taskService = taskService;
	}
	
	public Project createProject(Project project) {
		return this.projectRepository.save(project);
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public List<Project> getAllProjectsWithTaskStatus(){
		
		List<Project> projectList = getAllProjects();
		for (Project project : projectList) {
			Long totalTasks = this.taskService.getAllProjectTasks(project.getProjectId());
			project.setTotalTasks(totalTasks);
		}
		return projectList;
	}
	
	
}
