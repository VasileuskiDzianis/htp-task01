package by.htp.task01.service.impl;

import by.htp.task01.dao.UserDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.User;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void signIn(User user) throws ServiceException {
		
		encryptUserPassword(user);

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
		
		encryptUserPassword(user);
		
		try {
			userDAO.signUp(user);
		} catch (DAOException e) {
			throw new ServiceException("Error sign up", e);
		}
	}
	
	private void encryptUserPassword(User user) {
		
		String encryptedPassword = Integer.toString(user.getPassword().hashCode());
				
		user.setPassword(encryptedPassword);
	}

}
