package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;

public class DestroySource implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddNewBook.class);
	
	private InitializationService initializationService;

	public void setInitializationService(InitializationService initializationService) {
		this.initializationService = initializationService;
	}

	@Override
	public String executeCommand(String request) {

		try {
			initializationService.destroy();

			return "Database has been destroyed";
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);
			
			return "Database has not been destroyed";
		}
	}
}
