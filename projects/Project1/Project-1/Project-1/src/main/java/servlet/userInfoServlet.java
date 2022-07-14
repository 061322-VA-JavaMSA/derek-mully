package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.user;
import service.userService;
import utilities.corsFix;

public class userInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	userService us = new userService();
	private ObjectMapper om = new ObjectMapper();


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		corsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		String pathInfo = req.getPathInfo();
		//String username = req.getParameter("username");
		if(pathInfo == null) {
			user u = us.getUsersByUsername("iris");
			PrintWriter pw = res.getWriter();
			pw.write(om.writeValueAsString(u));
			pw.close();
		}
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		corsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		InputStream reqBody = req.getInputStream();
		
		user u = om.readValue(reqBody, user.class);
		System.out.println(u);
		us.updateUserInfo(u);
		
		
		res.setStatus(200);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		corsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
}