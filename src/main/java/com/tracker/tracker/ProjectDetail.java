package com.tracker.tracker;

public class ProjectDetail extends Project{
	Long totalTasks;
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
	
}
