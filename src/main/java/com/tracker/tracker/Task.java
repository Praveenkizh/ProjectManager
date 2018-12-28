package com.tracker.tracker;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="task")
public class Task implements Serializable {

    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long taskId;
    
//    @Column(name="parent_id")
//    private Long parentId;
    
    @ManyToOne (cascade=CascadeType.MERGE)
    @JoinColumn(name="parent_id")
    private ParentTask parentTask;
    
    @Column(name="project_id")
    private Long projectId;
    
    @Column(name="task")
	private String task;
    
	 @Temporal(TemporalType.DATE)
	 @Column(name="start_date")
	private Date startDate;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name="end_date")
	private Date endDate;
	
	 @Column(name="priority")
	private Long priority;
	 
	@Column(name="active")
	private Boolean active;
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

//	public Long getParentId() {
//		return parentId;
//	}
//
//	public void setParentId(Long parentId) {
//		this.parentId = parentId;
//	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	
	
	
	
	
	
	
	
}
