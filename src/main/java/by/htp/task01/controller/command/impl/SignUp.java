package by.htp.task01.controller.command.impl;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.UserService;
import by.htp.task01.service.exception.ServiceException;

public class SignUp implements Command {
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
			
			return "Sign up error";
		}
	}
}
