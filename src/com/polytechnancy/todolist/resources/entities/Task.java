package com.polytechnancy.todolist.resources.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "task_name", length = 50)
	private String taskName;
	
	public Task(String taskName) {
		this.taskName = taskName;
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
}
