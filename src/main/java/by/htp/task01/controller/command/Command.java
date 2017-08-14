package by.htp.task01.controller.command;

public interface Command {
	String COMMAND_SPLITTER = " ";
	
	static final int LOGIN_ORDER = 1;
	static final int PASSWORD_ORDER = 2;
	
	public String executeCommand(String request);
}
