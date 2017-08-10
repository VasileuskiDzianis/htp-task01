package by.htp.task01.dao.factory;

import by.htp.task01.dao.BookDAO;
import by.htp.task01.dao.InitializationDAO;
import by.htp.task01.dao.UserDAO;
import by.htp.task01.dao.impl.BookDAOImpl;
import by.htp.task01.dao.impl.InitializationDAOImpl;
import by.htp.task01.dao.impl.UserDAOImpl;

public final class DAOFactory {
	private static DAOFactory instance = null;
	private final UserDAO userDAO = new UserDAOImpl();
	private final BookDAO bookDAO = new BookDAOImpl();
	private final InitializationDAO initializationDAO = new InitializationDAOImpl();
	
	private DAOFactory() {}

	public static DAOFactory getInstance() {
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public InitializationDAO getInitializationDAO() {
		return initializationDAO;
	}
	
}
