package by.htp.task01.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;

public class TestUserServiceImpl {

	UserService userService;
	
	@Before
	public void instantiateService() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-root-context.xml");
		userService = context.getBean("userService", UserService.class);
		context.close();
	}
	
	@Test (expected = NullPointerException.class)
	public void signUp() throws ServiceException{

		userService.signUp(null);
	}
}
