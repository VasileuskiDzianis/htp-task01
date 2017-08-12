package by.htp.task01.controller.command;

import java.util.Map;

public final class CommandProviderImpl implements CommandProvider {
	private Map<CommandName, Command> commandRepository;

	public void setCommandRepository(Map<CommandName, Command> commandRepository) {
		this.commandRepository = commandRepository;
	}

	@Override
	public Command getCommand(String key) {
		CommandName commandName;

		try {
			commandName = CommandName.valueOf(key.toUpperCase());

			return commandRepository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {

			return commandRepository.get(CommandName.WRONG_REQUEST);
		}
	}
}
