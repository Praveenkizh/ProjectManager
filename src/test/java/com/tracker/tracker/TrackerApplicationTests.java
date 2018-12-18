package com.tracker.tracker;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class TrackerApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	private TaskService taskService;
	
	//@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testGetAll() {
		Task task = new Task();
		//task.setTaskId(1L);
		task.setTask("Test");
		task.setStatus("Active");
		task.setStartDate(new Date(12/15/2018));
		task.setEndDate(new Date(12/14/2019));
		task.setPriority(1L);
		task.setParentId(1L);
		
		entityManager.persist(task);
		
		taskService = new TaskService(taskRepository);
		List<Task> tasks = taskService.getAllTasks();
		Assert.assertEquals(1L, tasks.size());
	}
	
	@Test
	public void createTask() {
		Task task = new Task();
		//task.setTaskId(1L);
		task.setTask("Test");
		task.setStatus("Active");
		task.setStartDate(new Date(12/15/2018));
		task.setEndDate(new Date(12/14/2019));
		task.setPriority(1L);
		task.setParentId(1L);
	
		taskService = new TaskService(taskRepository);
		Task returnTask = taskService.createTask(task);
		Assert.assertEquals(returnTask.getTask(), task.getTask());
	}
	
	@Test
	public void updateTask() {
		Task task = new Task();
		//task.setTaskId(1L);
		task.setTask("Test1");
		task.setStatus("Active");
		task.setStartDate(new Date(12/15/2018));
		task.setEndDate(new Date(12/14/2019));
		task.setPriority(1L);
		task.setParentId(1L);
		Task returnTask = entityManager.persist(task);
		returnTask.setTask("Task");
		
		taskService = new TaskService(taskRepository);
		Task updatedTask = taskService.updateTask(returnTask);
		Assert.assertEquals("Task", updatedTask.getTask());
	}
	

}
