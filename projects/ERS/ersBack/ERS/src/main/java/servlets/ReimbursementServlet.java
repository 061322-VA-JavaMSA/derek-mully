package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ReimbursementDTO;
import dto.ReqReimStatusDTO;
import dto.ReqReimbursementDTO;
import exceptions.ReimbursementNotCreatedException;
import exceptions.ReimbursementNotFoundException;
import exceptions.ReimbursementStatusNotFoundException;
import exceptions.ReimbursementTypeNotFoundException;
import exceptions.UserNotFoundException;
import models.Reimbursement;
import services.AuthService;
import services.ReimbursementNotUpdatedException;
import services.ReimbursementService;
import services.ReimbursementStatusService;
import services.ReimbursementTypeService;
import services.UserService;
import services.ValidateService;
import util.CorsFix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbursementServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	private ReimbursementStatusService rss = new ReimbursementStatusService();
	private ReimbursementTypeService rt = new ReimbursementTypeService();
	private UserService us = new UserService();
	private AuthService as = new AuthService();
	private ValidateService vs = new ValidateService();
	private ObjectMapper om = new ObjectMapper();
	private static Logger log = LogManager.getLogger(ReimbursementServlet.class);

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		String pathInfo = req.getPathInfo();
		if (vs.checkManager(req, resp) == true) {
 			if (pathInfo == null) {

				List<Reimbursement> reimburse = rs.getReimburse();

				PrintWriter pw = resp.getWriter();
				List<ReimbursementDTO> reimDTO = new ArrayList<>();
				reimburse.forEach(r -> reimDTO.add(new ReimbursementDTO(r)));
				pw.write(om.writeValueAsString(reimDTO));
				pw.close();
				resp.setStatus(200);

			} else {
				log.info("Get single Reimbursement by id"); 
				int id = Integer.parseInt(pathInfo.substring(1));
				try {
					ReimbursementDTO reimDTO = new ReimbursementDTO(rs.getByID(id));
					PrintWriter pw = resp.getWriter();
					pw.write(om.writeValueAsString(reimDTO));
					pw.close();
				} catch (ReimbursementNotFoundException e) {
					// TODO Auto-generated catch block
					log.info("Reimbursement Not Found"); 
					vs.messageWrite(req, resp, 404);
					e.printStackTrace();
				}

			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		InputStream reqBody = req.getInputStream();

		ReqReimbursementDTO newReimbursementDTO = om.readValue(reqBody, ReqReimbursementDTO.class);
		Reimbursement newReimbursement = new Reimbursement();
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		log.info("Create Reimbursement");	
		try {
			newReimbursement.setAmount(newReimbursementDTO.getAmount());
			newReimbursement.setDescription(newReimbursementDTO.getDescription());
			newReimbursement.setAuthor(us.getUserById(newReimbursementDTO.getAuthor_id()));
			newReimbursement.setReim_status(rss.getReimbursementStatusById(1));
			newReimbursement.setReim_type(rt.getReimbursementTypeById(newReimbursementDTO.getReimb_type_id()));
			newReimbursement.setSubmitted(timestamp1);
			log.info(newReimbursement);	
			Reimbursement newR = rs.insertReimbursement(newReimbursement);
			try (PrintWriter pw = resp.getWriter()) {
				pw.write(1);
				resp.setStatus(200);
			}
		} catch (ReimbursementNotCreatedException | UserNotFoundException | ReimbursementStatusNotFoundException
				| ReimbursementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			log.info("Reimbursement Not Created");	
			vs.messageWrite(req, resp, 404);
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPut(req, resp);
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		String pathInfo = req.getPathInfo();
		InputStream reqBody = req.getInputStream();

		if (vs.checkManager(req, resp) == true) {
			ReqReimStatusDTO statusDTO = om.readValue(reqBody, ReqReimStatusDTO.class);

 			int id = Integer.parseInt(pathInfo.substring(1));
 			if (vs.checkManager(req, resp) == true) {
				statusDTO.setId(id);
				log.info("Update Reimbursement");	

				try {
					ReimbursementDTO reimDTO = new ReimbursementDTO(rs.getByID(id));
					log.info(id);	
   					if(reimDTO.getReim_status().getReimb_status().equals("pending")) {
 						rs.setStatusByID(statusDTO.getId(), statusDTO.getUser_id(), statusDTO.getStatus());
 						try (PrintWriter pw = resp.getWriter()) {
 							reimDTO = new ReimbursementDTO(rs.getByID(id));
 							pw.write(om.writeValueAsString(reimDTO));
 							resp.setStatus(200);
 							pw.close();
 						}
 					} else {
 						vs.messageWrite(req, resp, 409);
 					}					
				} catch (ReimbursementNotFoundException | ReimbursementNotUpdatedException e) {
					// TODO Auto-generated catch block
					log.info("Update Reimbursement Not Found");	
					vs.messageWrite(req, resp, 404);

					e.printStackTrace();
				}
			}

		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}