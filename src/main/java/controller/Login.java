package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rest.UserService;

public class Login extends HttpServlet {

	private static final long serialVersionUID = -5248890857301913501L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, res);
	}

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserService us = new UserService();
		String[] username = req.getParameterValues("username");
		String[] password = req.getParameterValues("password");
		String user = username[username.length - 1];
		String pass = password[password.length - 1];

		if (/*us.findUser(user, pass)*/ true) {
			RequestDispatcher view = req.getRequestDispatcher("Booking.jsp");
			view.forward(req, res);
		} else {
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			view.forward(req, res);
		}
	}
}
