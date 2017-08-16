package by.htp.task01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import by.htp.task01.controller.command.Command;
import by.htp.task01.controller.command.CommandProvider;

@Controller
public final class RequestExecutorController {
	private final static char PARAMETERS_DELIMITER = ' ';
	private final static int COMMAND_INDEX = 0;
	
	@Autowired
	private CommandProvider commandProvider;
	
	public String executeAction(String request){
		Command command = commandProvider.getCommand(extractCommandNameFromRequest(request));
		
		return command.executeCommand(request);
	}
	
	private String extractCommandNameFromRequest(String request) {
		
		return request.substring(COMMAND_INDEX, request.indexOf(PARAMETERS_DELIMITER));
	}
}
