package by.htp.task01.controller.command.impl;

import java.util.List;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;

public class GetBookList implements Command {
	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String executeCommand(String request) {

		List<Book> booklist = bookService.getBookList();
		StringBuilder result = new StringBuilder();
		for (Book book : booklist) {
			result.append("<book>");
			result.append(book);
			result.append("</book>");
		}

		return result.toString();
	}
}
