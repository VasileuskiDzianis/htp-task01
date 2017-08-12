package by.htp.task01.service.impl;

import java.util.IllegalFormatException;
import java.util.List;

import by.htp.task01.dao.BookDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;
import by.htp.task01.service.validation.DataValidatorService;

public class BookServiceImpl implements BookService {
	BookDAO bookDAO;

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public void addNewBook(String title, String genre, String author, String year, String quantityStr)
			throws ServiceException {
		if (!DataValidatorService.validBook(title, genre, author, year, quantityStr)) {
			throw new ServiceException("Incorrect data about book");
		}

		int quantity = 0;
		try {
			quantity = Integer.parseInt(quantityStr);
		} catch (IllegalFormatException e) {
			throw new ServiceException("Year format exception");
		}

		try {
			bookDAO.addNewBook(title, author, genre, year, quantity);
		} catch (DAOException e) {
			throw new ServiceException("Error adding a book to the library");
		}

	}

	@Override
	public void addEditBook(String title, String genre, String author, String year, String quantityStr,
			String idBookStr) throws ServiceException {
		if (!DataValidatorService.validBook(title, genre, author, year, quantityStr, idBookStr)) {
			throw new ServiceException("Incorrect data about book");
		}

		int idBook = Integer.parseInt(idBookStr);
		int quantity = Integer.parseInt(quantityStr);

		try {
			bookDAO.addEditBook(title, genre, author, year, quantity, idBook);
		} catch (DAOException e) {
			throw new ServiceException("Error editing book");
		}
	}

	@Override
	public List<Book> getBookList() throws ServiceException {
		List<Book> booklist = null;

		try {
			booklist = bookDAO.getBooklist();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (booklist == null) {
			throw new ServiceException("Booklist not found");
		}

		return booklist;
	}
}