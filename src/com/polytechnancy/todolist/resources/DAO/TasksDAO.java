package com.polytechnancy.todolist.resources.DAO;

import java.util.List;

import javax.ejb.Local;

import com.polytechnancy.todolist.resources.entities.Task;

@Local
public interface TasksDAO {

	public Task findById(int id);
	public List<Task> findAll();
	public void remove(int taskId);
	public void add(Task task);
}
