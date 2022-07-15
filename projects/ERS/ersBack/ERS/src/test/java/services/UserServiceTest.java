package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.booleanThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.UserDAO;
import exceptions.UserNotFoundException;
import exceptions.UserNotUpdatedException;
import models.Role;
import models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private static UserDAO mockUserDao;
	@InjectMocks
	private static UserService sut;
	
	@BeforeAll
	public static void setup() {
		sut = new UserService();
	}
	
	@Test
	public void getUserByIdExists() throws UserNotFoundException {
		Role role = new Role();
		role.setId(2);
		role.setUser_role("manager");

		User udaoExpected = new User();
		udaoExpected.setId(1);
		udaoExpected.setUsername("kev");
		udaoExpected.setPassword("pass");
		udaoExpected.setRole(role);
		
		User uservExpected = new User();
		uservExpected.setId(1);
		uservExpected.setUsername("kev");
		uservExpected.setPassword("pass");
		uservExpected.setRole(role);
		
		Mockito.when(mockUserDao.getUserById(1)).thenReturn(udaoExpected);
		
		User uservActual = sut.getUserById(1);
		
		assertEquals(uservExpected, uservActual);
	}
	
	@Test
	public void getUserByIdDoesNotExist() {
		/*-
		 * Mocking allows us to "mock" dependencies:
		 * 		- in this case sut will call .getUserById() from mockUserDao instead of UserHibernate
		 * 		- We can control what mockUserDao will return, in this case it will return null for id = 3
		 */
		Mockito.when(mockUserDao.getUserById(3)).thenReturn(null);
		
		// sut calls mockUserDao.getUserById(1); instead of calling UserHibernate's implementation - ud.getUserById(1)
		assertThrows(UserNotFoundException.class, () -> sut.getUserById(3));
	}
	
	@Test
	public void updatetUserExists() throws UserNotUpdatedException {
		Role role = new Role();
		role.setId(2);
		role.setUser_role("manager");;

		User udaoExpected = new User();
		udaoExpected.setId(4);
		udaoExpected.setUsername("kev");
		udaoExpected.setPassword("pass");
		udaoExpected.setRole(role);
	 
		
		boolean checkExpected = true;
		Mockito.when(mockUserDao.updatetUser(udaoExpected)).thenReturn(checkExpected);
		boolean  booleanActual = sut.updatetUser(udaoExpected);
		assertEquals(booleanActual, checkExpected);
 	}	
	
	@Test
	public void updatetUserNOTExists() throws UserNotUpdatedException {
		Role role = new Role();
		role.setId(2);
		role.setUser_role("manager");;

		User udaoExpected = new User();
		udaoExpected.setId(4);
		udaoExpected.setUsername("kev");
		udaoExpected.setPassword("pass");
		udaoExpected.setRole(role);
	 
		
		boolean checkExpected = true;
		Mockito.when(mockUserDao.updatetUser(udaoExpected)).thenReturn(false);
  		
		assertThrows(UserNotUpdatedException.class, () -> sut.updatetUser(udaoExpected));
 	}	
}