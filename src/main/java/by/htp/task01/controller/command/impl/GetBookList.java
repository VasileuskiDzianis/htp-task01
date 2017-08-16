package by.htp.task01.controller.command.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

@Component
public class GetBookList implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetBookList.class);

	@Autowired
	BookService bookService;

	@Override
	public String executeCommand(String request) {
		List<Book> booklist = null;

		try {
			booklist = bookService.getBookList();
			StringBuilder result = new StringBuilder();
			for (Book book : booklist) {
				result.append("<book>");
				result.append(book);
				result.append("</book>");
			}
			
			return result.toString();
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Error getting list of books";
		}
	}
}
