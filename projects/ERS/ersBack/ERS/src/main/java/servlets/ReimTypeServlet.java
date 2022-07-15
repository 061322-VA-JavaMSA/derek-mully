package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ReimbursementType;
import services.ReimbursementTypeService;
import util.CorsFix;

public class ReimTypeServlet extends HttpServlet {
	private ReimbursementTypeService rt = new ReimbursementTypeService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		List<ReimbursementType> reimType = rt.getReimbursementType();
		PrintWriter pw = resp.getWriter();
		pw.write(om.writeValueAsString(reimType));
		pw.close();
	}

}