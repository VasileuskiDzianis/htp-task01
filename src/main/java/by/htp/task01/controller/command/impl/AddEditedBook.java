package by.htp.task01.controller.command.impl;

import org.apache.log4j.Logger;

import by.htp.task01.controller.command.Command;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.validation.DataValidatorService;

public class AddEditedBook implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddEditedBook.class);

	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String executeCommand(String request) {
		Book book;

		String[] parameter = request.split(COMMAND_SPLITTER);
		String title = parameter[1];
		String author = parameter[2];
		String genre = parameter[3];
		String year = parameter[4];
		String quantity = parameter[5];
		String bookId = parameter[6];

		if (DataValidatorService.validateString(title) && DataValidatorService.validateString(author)
				&& DataValidatorService.validateString(genre) && DataValidatorService.validateYear(year)
				&& DataValidatorService.validateNumber(quantity) && DataValidatorService.validateNumber(bookId)) {

			book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setGenre(genre);
			book.setYear(year);
			book.setQuantity(Integer.parseInt(quantity));
			book.setId(Integer.parseInt(bookId));

		} else {

			return "Incorrect book data";
		}
		try {
			bookService.addEditBook(book);

			return "Book successfully edited";
		} catch (ServiceException e) {
			LOGGER.error("Exception occur, ", e);

			return "Error editing book";
		}
	}
}
