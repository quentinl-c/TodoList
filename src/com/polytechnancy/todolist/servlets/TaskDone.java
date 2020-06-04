package com.polytechnancy.todolist.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polytechnancy.todolist.resources.DAO.TasksDAO;

/**
 * Servlet implementation class TaskDone
 */
@WebServlet("/TaskDone")
public class TaskDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String url = "welcome";
	@EJB
	private TasksDAO tasksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String taskId = request.getParameter("taskId");
		int id;
		
		try {
			
			id = Integer.parseInt(taskId);
			
			tasksDAO.remove(id);
			
			
		} catch (NumberFormatException e) {
			System.err.println("Invalid Id");
		}
		finally {
			response.sendRedirect(url);
		}
		
		
	}

}
