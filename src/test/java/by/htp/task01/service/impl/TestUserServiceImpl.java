package by.htp.task01.service.impl;

import org.junit.Test;

import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.factory.ServiceFactory;

public class TestUserServiceImpl {
/*	Зарегистрировать пользователя не получиться, т.к. мы не инициализировали ConnectionPool
 	Соответственно когда берем Connection получаем NullPointerException.
*/
	@Test (expected = NullPointerException.class)
	public void signUp() throws ServiceException{
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		userService.signUp("Dylan O'Brien", "12345678");
	}
}
