package by.htp.task01.service.impl;

import by.htp.task01.dao.UserDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.User;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.validation.DataValidatorService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void signIn(User user) throws ServiceException {

		if (!DataValidatorService.validateString(user.getLogin())
				|| !DataValidatorService.validateString(user.getPassword())) {

			throw new ServiceException("Incorrect user's login or password");
		}

		user.setPassword(getEncryptedPassword(user.getPassword()));

		try {
			userDAO.signIn(user);
			if (user.getId() == 0) {
				throw new ServiceException("User wasn't found");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error sign in", e);
		}
	}

	@Override
	public void signUp(User user) throws ServiceException {

		if (!DataValidatorService.validateString(user.getLogin())
				|| !DataValidatorService.validateString(user.getPassword())) {

			throw new ServiceException("Incorrect user's login or password");
		}

		user.setPassword(getEncryptedPassword(user.getPassword()));

		try {
			userDAO.signUp(user);
		} catch (DAOException e) {
			throw new ServiceException("Error sign up", e);
		}
	}

	private String getEncryptedPassword(String password) {

		return Integer.toString(password.hashCode());
	}
}
