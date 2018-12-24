package com.tracker.tracker;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class ProjectServiceTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	private ProjectService projectService;
	
	@Test
	public void createTask() {
		Project project = new Project();
		//task.setTaskId(1L);
		project.setProject("Project 1");
		project.setStartDate(new Date(12/15/2018));
		project.setEndDate(new Date(12/14/2019));
		project.setPriority(1L);
		//task.setParentId(1L);
		
	
		projectService = new ProjectService(projectRepository);
		Project returnProject = projectService.createProject(project);
		Assert.assertEquals("Project 1", returnProject.getProject());
	}

}
