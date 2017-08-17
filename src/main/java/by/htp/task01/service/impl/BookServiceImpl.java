package by.htp.task01.service.impl;

import java.util.List;

import by.htp.task01.dao.BookDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

import static by.htp.task01.service.validation.DataValidatorService.validateString;
import static by.htp.task01.service.validation.DataValidatorService.validateYear;

public class BookServiceImpl implements BookService {
	BookDAO bookDAO;

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public void addNewBook(Book book) throws ServiceException {
		if (!validateBook(book)) {
			throw new ServiceException("Incorrect book data");
		}
		
		try {
			bookDAO.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("Error adding a book to the library", e);
		}

	}

	@Override
	public void addEditBook(Book book) throws ServiceException {
		if (!validateBook(book)) {
			throw new ServiceException("Incorrect book data");
		}
		
		try {
			bookDAO.addEditBook(book);
		} catch (DAOException e) {
			throw new ServiceException("Error editing book", e);
		}
	}

	@Override
	public List<Book> getBookList() {
		
		return bookDAO.getBooklist();
	}

	public boolean validateBook(Book book) {
		if (validateString(book.getTitle()) && validateString(book.getAuthor()) && validateString(book.getGenre())
				&& validateYear(book.getYear())) {
			return true;
		} else {
			return false;
		}
	}
}