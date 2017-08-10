package by.htp.task01.controller.command.impl;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.factory.ServiceFactory;

public class DestroySource implements Command {

	@Override
	public String executeCommand(String request) {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitializationService initializationService = factory.getInitializationService();
		String response = null;
		
		try {
			initializationService.destroy();
			response = "Database has been destroyed";
		} catch (ServiceException e) {
			response = "Database has not been destroyed";
//			LOGGER.error(e);	
		}
		
		return response;
	}

}
