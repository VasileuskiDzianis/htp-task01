package by.htp.task01.controller;

import by.htp.task01.controller.command.Command;
import by.htp.task01.controller.command.CommandProvider;

public final class RequestExecutorController {
	private final static char PARAMETERS_DELIMITER = ' ';
	private final static int COMMAND_INDEX = 0;
	
	private CommandProvider commandProvider;
	
	public void setCommandProvider(CommandProvider commandProvider) {
		this.commandProvider = commandProvider;
	}

	public String executeAction(String request){
		Command command = commandProvider.getCommand(extractCommandNameFromRequest(request));
		
		return command.executeCommand(request);
	}
	
	private String extractCommandNameFromRequest(String request) {
		
		return request.substring(COMMAND_INDEX, request.indexOf(PARAMETERS_DELIMITER));
	}
}
