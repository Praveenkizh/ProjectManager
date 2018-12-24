package com.tracker.tracker;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectService {
	private ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public Project createProject(Project project) {
		return this.projectRepository.save(project);
	}
}
