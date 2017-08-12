package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;

public class SignIn implements Command {
	private static final Logger LOGGER = Logger.getLogger(InitializeSource.class);

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeCommand(String request) {
		String[] parameter = request.split(COMMAND_SPLITTER);
		String login = parameter[1];
		String password = parameter[2];

		try {
			userService.signIn(login, password);

			return "Welcome " + login;
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Sign in error";
		}
	}
}
