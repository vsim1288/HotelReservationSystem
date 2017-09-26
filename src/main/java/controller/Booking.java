package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Booking extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1141761679823768662L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		RequestDispatcher rd = req.getRequestDispatcher("Booking.jsp");
		rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
