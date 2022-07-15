package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.UserHibernate;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private static UserHibernate uht;
	
	@InjectMocks
	private static UserService sut;
	
	@BeforeAll
	public static void setup() {
		sut = new UserService();
	}
	
	
	@Test
	public void getUserByNameExists() throws UserNotFoundException {
		User expected = new User();
		expected.setId(1);
		expected.setRole(User.Role.EMPLOYEE);
		expected.setUser_name("Chris");
		expected.setUser_pass("p4ssword");
		expected.setUsername("Chris");
		
		Mockito.when(uht.getUserByName("Chris")).thenReturn(expected);
		
		User actual = sut.getUserByName("Chris");
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void getUserByNameNotExists() throws UserNotFoundException {
		
		Mockito.when(uht.getUserByName("Derek")).thenReturn(null);
		
		assertThrows(UserNotFoundException.class, ()->sut.getUserByName("Derek"));
	}
	
	
	
	@Test
	public void getUserByIdExists() throws UserNotFoundException {
		User expected = new User();
		expected.setId(3);
		expected.setRole(User.Role.MANAGER);
		expected.setUser_name("Derek");
		expected.setUser_pass("password");
		expected.setUsername("Derek");
		
		Mockito.when(uht.getUserByID(3)).thenReturn(expected);
		
		User actual = sut.getUserByID(3);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void getUserByIdNotExists() throws UserNotFoundException {
		
		Mockito.when(uht.getUserByID(7)).thenReturn(null);
		
		assertThrows(UserNotFoundException.class, ()->sut.getUserByID(7));
	}
	
	
	@Test
	public void updateUNNotExists() throws UserNotFoundException {	
		assertThrows(UserNotFoundException.class, ()->sut.updateUN("Dave", "Dave"));
	}
	
	@Test
	public void updatePNotExists() throws UserNotFoundException {	
		assertThrows(UserNotFoundException.class, ()->sut.updateP("Dave1", 9));
	}
	
	@Test
	public void updateNNotExists() throws UserNotFoundException {	
		assertThrows(UserNotFoundException.class, ()->sut.updateN("Dave1", 9));
	}
}