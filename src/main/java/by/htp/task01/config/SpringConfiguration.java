package by.htp.task01.config;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.htp.task01.controller.command.Command;
import by.htp.task01.controller.command.CommandName;

@Configuration
public class SpringConfiguration {
	@Autowired
	Command addEditedBook;
	@Autowired
	Command addNewBook;
	@Autowired
	Command getBookList;
	@Autowired
	Command signIn;
	@Autowired
	Command signUp;
	@Autowired
	Command wrongRequest;
	
	@Bean
	public Map<CommandName, Command> commandRepository() {
		
		Map<CommandName, Command> commands = new EnumMap<>(CommandName.class);
		commands.put(CommandName.SIGN_IN, signIn);
		commands.put(CommandName.SIGN_UP, signUp);
		commands.put(CommandName.ADD_EDITED_BOOK, addEditedBook);
		commands.put(CommandName.ADD_NEW_BOOK, addNewBook);
		commands.put(CommandName.GET_BOOKLIST, getBookList);
		commands.put(CommandName.WRONG_REQUEST, wrongRequest);
		
		return commands;
	}
}
