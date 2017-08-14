package by.htp.task01.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.task01.dao.BookDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

public class BookServiceImpl implements BookService {
	BookDAO bookDAO;

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public void addNewBook(Book book) throws ServiceException {
		try {
			bookDAO.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("Error adding a book to the library", e);
		}

	}

	@Override
	public void addEditBook(Book book) throws ServiceException {
		try {
			bookDAO.addEditBook(book);
		} catch (DAOException e) {
			throw new ServiceException("Error editing book", e);
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
			booklist = new ArrayList<Book>();
		}
		return booklist;
	}
}