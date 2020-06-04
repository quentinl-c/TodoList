package com.polytechnancy.todolist.resources.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.polytechnancy.todolist.resources.entities.Task;



@Stateless
public class TasksDAOImpl implements TasksDAO {
	
	@PersistenceContext(unitName = "TodoListPU")
	private EntityManager em;
	
	public Task findById(int id) {
		
		return em.find(Task.class, id);
	}
	
	public List<Task> findAll() {
		return em.createQuery( "SELECT t FROM Task t", Task.class).getResultList();
	}
	
	public void remove(int taskId) {
	    Task task = em.find(Task.class, taskId);    
		if (task != null) {
			em.remove(task);      
		}
	}
	
	public void add(Task task) {
		em.persist(task);
	}
}
