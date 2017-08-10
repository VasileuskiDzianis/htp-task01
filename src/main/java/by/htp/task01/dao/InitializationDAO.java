package by.htp.task01.dao;

import by.htp.task01.dao.exception.DAOException;

public interface InitializationDAO {
	void initialization() throws DAOException;
	void destroy() throws DAOException;
}
