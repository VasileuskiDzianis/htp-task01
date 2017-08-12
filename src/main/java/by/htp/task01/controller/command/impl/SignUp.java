package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;

public class SignUp implements Command {
	private static final Logger LOGGER = Logger.getLogger(SignUp.class);

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeCommand(String request) {
		String[] parameter = request.split(" ");
		String login = parameter[1];
		String password = parameter[2];

		try {
			userService.signUp(login, password);

			return "User was registered " + login;
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Sign up error";
		}
	}
}
