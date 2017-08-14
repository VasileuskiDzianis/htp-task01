package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.User;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.validation.DataValidatorService;

public class SignIn implements Command {
	private static final Logger LOGGER = Logger.getLogger(SignIn.class);
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeCommand(String request) {
		User user;
		
		String[] parameter = request.split(COMMAND_SPLITTER);
		String login = parameter[LOGIN_ORDER];
		String password = parameter[PASSWORD_ORDER];
		
		if (DataValidatorService.validateString(login) && DataValidatorService.validateString(password)) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
		} else {
			
			return "Inccorrent user's login or password";
		}

		try {
			userService.signIn(user);

			return "Welcome " + login;
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Sign in error";
		}
	}
}
