package by.htp.task01.service;

import by.htp.task01.domain.User;
import by.htp.task01.service.exception.ServiceException;

public interface UserService {
	void signIn(User user) throws ServiceException;
	void signUp(User user) throws ServiceException;
}
