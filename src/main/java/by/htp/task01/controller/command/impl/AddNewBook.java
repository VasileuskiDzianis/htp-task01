package by.htp.task01.controller.command.impl;

import by.htp.task01.controller.command.Command;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.factory.ServiceFactory;

public class AddNewBook implements Command {

	@Override
	public String executeCommand(String request) {
		String [] parameter = request.split(" ");
		String title = parameter[1];
		String author = parameter[2];
		String genre = parameter[3];
		String year = parameter[4];
		String quantity = parameter[5];
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		String response = null;
		
		try {
			bookService.addNewBook(title, genre, author, year, quantity);
			response = "Book successfully added";
		} catch (ServiceException e) {
			response = "Error adding book";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
