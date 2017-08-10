package by.htp.task01.dao;

import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.User;

public interface UserDAO {
	User signIn(String login, int password) throws DAOException;
	void signUp(String login, int password) throws DAOException;
}
