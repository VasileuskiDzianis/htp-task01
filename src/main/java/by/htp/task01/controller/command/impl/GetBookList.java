package by.htp.task01.controller.command.impl;

import java.util.List;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

public class GetBookList implements Command {
	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String executeCommand(String request) {
		List<Book> booklist = null;

		try {
			booklist = bookService.getBookList();

			return "List of books received";
		} catch (ServiceException e) {

			return "Error getting list of books";
		}
	}
}
