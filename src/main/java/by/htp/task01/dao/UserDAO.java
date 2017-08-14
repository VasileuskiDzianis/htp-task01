package by.htp.task01.dao;

import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.User;

public interface UserDAO {
	void signIn(User user) throws DAOException;
	void signUp(User user) throws DAOException;
}
