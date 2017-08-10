package by.htp.task01.controller.command.impl;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.factory.ServiceFactory;

public class SignUp implements Command {

	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(" ");
		String login = parameter[1];
		String password = parameter[2];
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		String response = null;
		
		try {
			userService.signUp(login, password);
			response = "User was registrated " + login;
		} catch (ServiceException e) { 
			response = "Sign up error";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
