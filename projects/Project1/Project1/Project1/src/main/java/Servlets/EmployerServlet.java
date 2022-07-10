package Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import Models.Reimbursement;
import Services.EmployerService;
import Utilities.CorsFix;
import java.util.List;
public class EmployerServlet extends HttpServlet {

	/**
	 * 
	 */
	public static int id = 2;
	private static final long serialVersionUID = 1L;
	private EmployerService es = new EmployerService();
	private ObjectMapper om = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		
		String pathInfo = req.getPathInfo();
		om.registerModule(new JavaTimeModule());
		if(pathInfo == null) {
			List<Reimbursement> r = es.getReimbursement();
			PrintWriter pw = res.getWriter();
			pw.write(om.writeValueAsString(r));
			pw.close();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		
		InputStream reqBody = req.getInputStream();
		om.registerModule(new JavaTimeModule());
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		Reimbursement r = om.readValue(reqBody, Reimbursement.class);
		
		LocalDateTime now = LocalDateTime.now();
		r.setReimbResolved(now);
		es.updateReimbursement(r);
		res.setStatus(202);
		
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),res);
		super.doOptions(req, res);
	}
}