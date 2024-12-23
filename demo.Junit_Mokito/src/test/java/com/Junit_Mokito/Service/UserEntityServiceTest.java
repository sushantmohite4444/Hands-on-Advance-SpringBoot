package com.Junit_Mokito.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Junit_Mokito.Entity.UsersEntity;
import com.Junit_Mokito.Repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserEntityServiceTest {

	@BeforeAll
	public static void onlyonceAtStartingOnly() {
		System.out.println("BeforeAll");
	}

	@BeforeEach
	public void BeforeEverytestcall() {
		System.out.println("BeforeEach");
	}

	@AfterAll
	public static void AfterEverytestcall() {

		System.out.println("AfterAll");
	}

	@AfterEach
	public void OnlyonceAteratEnd() {
		System.out.println("AfterEach");
	}

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserEntityService userEntityService;

	@Test
	public void testSaveUser() {

		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setId(1);
		usersEntity.setUsername("sm");
		usersEntity.setPassword("123");

		Mockito.when(userRepository.save(usersEntity)).thenReturn(usersEntity);
		UsersEntity usersEntity1 = userEntityService.saveUser(usersEntity);

		System.out.println("First test");
		assertEquals(usersEntity, usersEntity1);
		assertNotNull(usersEntity1);
		//verify(userRepository,times( try 0,1,2)).save(any());

	}

	public void Testdelete() {

		doNothing().when(userRepository).deleteById(1);
		userEntityService.deleteUser(1);
		verify(userRepository, times(1)).deleteById(1);
	}

	@Test
	public void privateMethodAccess() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Method privateMethod = UserEntityService.class.
				getDeclaredMethod("Privatemethod", String.class);

		privateMethod.setAccessible(true);

		Boolean booleanval = (Boolean) privateMethod.invoke(userEntityService,"sm");

//		assertThrows(RuntimeException.class, ()-> new RuntimeException());

		System.out.println("Second method " + booleanval);
	}

}