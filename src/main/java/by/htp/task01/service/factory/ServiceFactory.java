package by.htp.task01.service.factory;

import by.htp.task01.service.BookService;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.UserService;
import by.htp.task01.service.impl.BookServiceImpl;
import by.htp.task01.service.impl.InitializationServiceImpl;
import by.htp.task01.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static ServiceFactory instance = null;
	private final UserService userService = new UserServiceImpl();
	private final BookService bookService = new BookServiceImpl();
	private final InitializationService initializationService = new InitializationServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public InitializationService getInitializationService() {
		return initializationService;
	}
	
}
