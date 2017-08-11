package by.htp.task01.service;

import by.htp.task01.service.exception.ServiceException;

public interface InitializationService {
	
	void initialize() throws ServiceException;
	void destroy() throws ServiceException;
}
