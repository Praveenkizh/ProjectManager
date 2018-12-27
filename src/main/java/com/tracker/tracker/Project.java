package com.tracker.tracker;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	
	@Column(name="project")
	private String project;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	 
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="priority")
	private Long priority;
	
	@Column(name="manager_id")
	private Long managerId;
	
	@Transient
	Long totalTasks;
	@Transient
	Long completedTasks;
	
	public Long getTotalTasks() {
		return totalTasks;
	}
	public void setTotalTasks(Long totalTasks) {
		this.totalTasks = totalTasks;
	}
	public Long getCompletedTasks() {
		return completedTasks;
	}
	public void setCompletedTasks(Long completedTasks) {
		this.completedTasks = completedTasks;
	}
	

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

}
