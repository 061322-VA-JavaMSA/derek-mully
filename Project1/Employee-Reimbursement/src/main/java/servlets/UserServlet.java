package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 

import dtos.UserDto;
import exceptions.UserNotCreatedException;
import exceptions.UserNotFoundException;
import models.Role;
import models.User;
import services.UserService;
import util.CorsFix;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");

		String pathInfo = req.getPathInfo();

	
		if (pathInfo == null) {

			List<User> users = us.getUsers();
			List<UserDto> usersDTO = new ArrayList<>();

			users.forEach(u -> usersDTO.add(new UserDto(u)));

			PrintWriter pw = res.getWriter();
			pw.write(om.writeValueAsString(usersDTO));

			pw.close();
			
		} else {
		
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
		
				User u = us.getUserById(id);
				UserDto uDTO = new UserDto(u);

		
				pw.write(om.writeValueAsString(uDTO));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
		
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		InputStream reqBody = req.getInputStream();

		User newUser = om.readValue(reqBody, User.class);

		try {
			us.createUser(newUser);

			res.setStatus(201); // Status: Created
		} catch (UserNotCreatedException e) {
//			res.setStatus(400);
			res.sendError(400, "Unable to create new user.");
			e.printStackTrace();
		}
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
}