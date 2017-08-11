package by.htp.task01.controller.command.impl;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.InitializationService;
import by.htp.task01.service.exception.ServiceException;

public class DestroySource implements Command {
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

			return "Database has not been destroyed";
		}
	}
}
