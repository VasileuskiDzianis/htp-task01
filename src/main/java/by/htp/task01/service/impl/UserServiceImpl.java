package by.htp.task01.service.impl;

import by.htp.task01.dao.UserDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.User;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.validation.ValidationData;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void signIn(String login, String password) throws ServiceException {
		if (!ValidationData.validUser(login, password)) {
			throw new ServiceException("Inccorrent user's login or password");
		}

		try {
			User user = userDAO.signIn(login, password.hashCode());
			if (user == null) {
				throw new ServiceException("User is not found");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error sign in", e);
		}
	}

	@Override
	public void signUp(String login, String password) throws ServiceException {
		if (!ValidationData.validUser(login, password)) {
			throw new ServiceException("Incorrent user's login or password");
		}

		// Attention String_paswword convert to int_password(HashCode)
		try {
			userDAO.signUp(login, password.hashCode());
		} catch (DAOException e) {
			throw new ServiceException("Error sign up", e);
		}
	}

}
