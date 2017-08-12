package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

public class AddNewBook implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddNewBook.class);

	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String executeCommand(String request) {
		String[] parameter = request.split(COMMAND_SPLITTER);
		String title = parameter[1];
		String author = parameter[2];
		String genre = parameter[3];
		String year = parameter[4];
		String quantity = parameter[5];

		try {
			bookService.addNewBook(title, genre, author, year, quantity);

			return "Book successfully was added";
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Error adding book";
		}
	}
}
