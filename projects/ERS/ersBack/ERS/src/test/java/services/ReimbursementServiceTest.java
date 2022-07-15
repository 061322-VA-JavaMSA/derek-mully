package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.ReimbursementDAO;
import exceptions.ReimbursementNotFoundException;
import exceptions.UserNotFoundException;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.Role;
import models.User;
 
@ExtendWith(MockitoExtension.class)
public class ReimbursementServiceTest {
	
	@Mock
	private static ReimbursementDAO mockRDao;
	@InjectMocks
	private static ReimbursementService srt;
	
	@BeforeAll
	public static void setup() {
		srt = new ReimbursementService();
	}

	@Test
	public void getByIDExists() throws ReimbursementNotFoundException {
	
		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setId(1);
		rs.setReimb_status("pending");
		
		ReimbursementType rt = new ReimbursementType();
		rt.setId(1);
		rt.setReimb_type("lodging");
		
		Reimbursement rdaoExpected = new Reimbursement();
		rdaoExpected.setId(1);
		rdaoExpected.setAmount(19);
		rdaoExpected.setDescription("Reimbursement");
		rdaoExpected.setReim_status(rs);
		rdaoExpected.setReim_type(rt);
		
		Mockito.when(mockRDao.getByID(1)).thenReturn(rdaoExpected);
		
		Reimbursement rActual = srt.getByID(1);
		
		assertEquals(rdaoExpected, rActual);
	}
	
	@Test
	public void getByIDNotExists() throws ReimbursementNotFoundException {
 
		Mockito.when(mockRDao.getByID(3)).thenReturn(null);
		
		assertThrows(ReimbursementNotFoundException.class, () -> srt.getByID(3));
	}
	
	@Test
	public void updateExists() throws ReimbursementNotUpdatedException {
		int userID = 4;
		Role role = new Role();
		role.setId(2);
		role.setUser_role("manager");;

		User approverUser = new User();
		approverUser.setId(33);
		approverUser.setUsername("manager");
		approverUser.setPassword("12345");
		approverUser.setFirst_name("Norbies");
		approverUser.setLast_name("Golagles");;
		approverUser.setEmail("ngolagleyt@sourceforge.net");;
 		approverUser.setRole(role);
		
		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setId(2);
		rs.setReimb_status("approved");
		int approverID = 33;
		
		boolean checkExpected = true;

 		Mockito.when(mockRDao.setStatusByID(userID, approverUser, rs)).thenReturn(checkExpected);
		
 		
		boolean  booleanActual =srt.setStatusByID(userID, approverID, "approved");
		assertEquals(booleanActual, checkExpected);
	}
	
	@Test
	public void updateNOTExists() throws ReimbursementNotUpdatedException {
		int userID = 4000;
		Role role = new Role();
		role.setId(2);
		role.setUser_role("manager");;

		User approverUser = new User();
		approverUser.setId(33);
		approverUser.setUsername("manager");
		approverUser.setPassword("12345");
		approverUser.setFirst_name("Norbies");
		approverUser.setLast_name("Golagles");;
		approverUser.setEmail("ngolagleyt@sourceforge.net");;
 		approverUser.setRole(role);
		
		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setId(2);
		rs.setReimb_status("approved");
		int approverID = 33;
		
 		Mockito.when(mockRDao.setStatusByID(userID, approverUser, rs)).thenReturn(false);
		
		assertThrows(ReimbursementNotUpdatedException.class, () -> srt.setStatusByID(userID, approverID, "approved"));
	}

}