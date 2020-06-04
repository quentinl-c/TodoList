package com.polytechnancy.todolist.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polytechnancy.todolist.resources.DAO.TasksDAO;
import com.polytechnancy.todolist.resources.entities.Task;


/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String url = "/WEB-INF/index.jsp";
	
	@EJB
	private TasksDAO tasksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final List<Task> tasks = tasksDAO.findAll();
		request.setAttribute("tasks", tasks);

		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}



}
