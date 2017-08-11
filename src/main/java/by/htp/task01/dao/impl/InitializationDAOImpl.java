package by.htp.task01.dao.impl;

import java.io.IOException;

import by.htp.task01.dao.InitializationDAO;
import by.htp.task01.dao.connection.ConnectionPool;
import by.htp.task01.dao.exception.ConnectionPoolException;
import by.htp.task01.dao.exception.DAOException;

public class InitializationDAOImpl implements InitializationDAO {
	private ConnectionPool connectionPool;

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}
	
	@Override
	public void initialize() throws DAOException {
		
		try {
			connectionPool.init();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem initialization database", e);
		}
	}

	@Override
	public void destroy() throws DAOException {
		
		try {
			connectionPool.close();
		} catch (IOException e) {
			throw new DAOException("Failure to close all connections", e);
		}
	}

}
