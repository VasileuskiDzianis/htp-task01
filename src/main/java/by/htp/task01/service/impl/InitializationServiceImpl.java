package by.htp.task01.service.impl;

import by.htp.task01.dao.InitializationDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;

public class InitializationServiceImpl implements InitializationService {

	private InitializationDAO initializationDAO;

	public void setInitializationDAO(InitializationDAO initializationDAO) {
		this.initializationDAO = initializationDAO;
	}

	@Override
	public void initialize() throws ServiceException {

		try {
			initializationDAO.initialize();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization", e);
		}
	}

	@Override
	public void destroy() throws ServiceException {

		try {
			initializationDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroy", e);
		}
	}
}
