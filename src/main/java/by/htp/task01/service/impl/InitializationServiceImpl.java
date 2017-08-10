package by.htp.task01.service.impl;

import by.htp.task01.dao.InitializationDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.dao.factory.DAOFactory;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;

public class InitializationServiceImpl implements InitializationService {

	@Override
	public void initialization() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		try {
			initializationDAO.initialization();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization",e);
		}
	}

	@Override
	public void destroy() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		
		try {
			initializationDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroy",e);
		}
	}

}
