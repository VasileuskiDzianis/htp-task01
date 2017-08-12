package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;

public class InitializeSource implements Command {
	private static final Logger LOGGER = Logger.getLogger(InitializeSource.class);
	
	private InitializationService initializationService;

	public void setInitializationService(InitializationService initializationService) {
		this.initializationService = initializationService;
	}

	@Override
	public String executeCommand(String request) {

		try {
			initializationService.initialize();

			return "Database has been initialized";
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);
			
			return "Database has not been initialized";
		}
	}
}
