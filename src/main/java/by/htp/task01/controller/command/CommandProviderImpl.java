package by.htp.task01.controller.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("commandProvider")
public final class CommandProviderImpl implements CommandProvider {
	@Autowired
	private Map<CommandName, Command> commandRepository;

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
