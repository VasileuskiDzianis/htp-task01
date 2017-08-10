package by.htp.task01.controller.command.impl;

import java.util.List;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.factory.ServiceFactory;

public class GetBookList implements Command {

	@Override
	public String executeCommand(String request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		
		List<Book> booklist = null;
		String response = null;
		try {
			booklist = bookService.getBooklist();
			response = "List of books received";
			
			//Circle just for test
			for(Book book: booklist){
				System.out.println(book.toString());
			}
		} catch (ServiceException e) {
			response = "Error getting list of books";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
