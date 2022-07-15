package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import daos.UserDao;
import exceptions.UserNotFoundException;
import models.Role;
import models.User;
import services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private static UserDao mockUserDao;
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
		udaoExpected.setUsername("testu");
		udaoExpected.setPassword("testp");
		udaoExpected.setRole(role);
		
		User uservExpected = new User();
		uservExpected.setId(1);
		uservExpected.setUsername("testu");
		uservExpected.setPassword("testp");
		uservExpected.setRole(role);
		
		Mockito.when(mockUserDao.getUserById(1)).thenReturn(udaoExpected);
		
		User uservActual = sut.getUserById(1);
		
		assertEquals(uservExpected, uservActual);
	}
	
	@Test
	public void getUserByIdDoesNotExist() {
		
		Mockito.when(mockUserDao.getUserById(12)).thenReturn(null);
	
		assertThrows(UserNotFoundException.class, () -> sut.getUserById(12));
	}
	


}