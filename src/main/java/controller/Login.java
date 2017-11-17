package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import rest.UserService;

public class Login extends HttpServlet {

	private static final long serialVersionUID = -5248890857301913501L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();

		session.setMaxInactiveInterval(5);

		if (session.isNew()) {
			RequestDispatcher view = req.getRequestDispatcher("./index.jsp");
			view.forward(req, res);
		} else {
			RequestDispatcher view = req.getRequestDispatcher("./Booking.jsp");
			view.forward(req, res);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User user = new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		UserService us = new UserService();
		
		if (us.findByUser(user)) {
			HttpSession session = req.getSession();

			session.setAttribute("user", user.getUsername());
			
			res.sendRedirect("./welcome");
		} else {
			RequestDispatcher view = req.getRequestDispatcher("./index.jsp");
			view.forward(req, res);
		}
	}
}
