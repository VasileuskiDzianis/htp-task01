package by.htp.task01.controller.command;

public interface Command {
	String COMMAND_SPLITTER = " ";
	
	public String executeCommand(String request);
}
