package com.polytechnancy.todolist.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polytechnancy.todolist.resources.DAO.TasksDAO;
import com.polytechnancy.todolist.resources.entities.Task;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String url = "welcome";
    
	@EJB
	private TasksDAO tasksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		final String taskName = request.getParameter("taskName");
		final Task task = new Task(taskName);
		tasksDAO.add(task);
		
		response.sendRedirect(url);
	}

}
