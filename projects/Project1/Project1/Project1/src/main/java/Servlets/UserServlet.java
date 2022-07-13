package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.DTOUser;
import Models.User;
import Services.UserService;
import Utilities.CorsFix;

public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
				CorsFix.addCorsHeader(req.getRequestURI(), res);
				res.addHeader("Content-Type", "application/json");

				String pathInfo = req.getPathInfo();


				if (pathInfo == null) {
					
						List<User> users = us.getUsers();
						List<User> users = new ArrayList<>();

						users.forEach(u -> User.add(new User(u)));

						PrintWriter pw = res.getWriter();
						pw.write(om.writeValueAsString(users));

						pw.close();
					
				} 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	}
	
}