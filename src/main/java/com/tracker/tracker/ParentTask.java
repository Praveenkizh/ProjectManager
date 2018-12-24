package com.tracker.tracker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parenttask")
public class ParentTask {
	
	@Id
    @Column(name="parent_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long parentId;
    
    @Column(name="parent_task")
    private String parentTask;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
