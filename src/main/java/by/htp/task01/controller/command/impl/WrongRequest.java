package by.htp.task01.controller.command.impl;

import org.springframework.stereotype.Component;

import by.htp.task01.controller.command.Command;

@Component
public class WrongRequest implements Command {

	@Override
	public String executeCommand(String request) {
		
		return "Wrong request!";
	}
}
