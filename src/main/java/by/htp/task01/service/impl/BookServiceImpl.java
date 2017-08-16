package by.htp.task01.service.impl;

import static by.htp.task01.service.validation.DataValidatorService.validateString;
import static by.htp.task01.service.validation.DataValidatorService.validateYear;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.task01.dao.BookDAO;
import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

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

	public boolean validateBook(Book book) {
		if (validateString(book.getTitle()) && validateString(book.getAuthor()) && validateString(book.getGenre())
				&& validateYear(book.getYear())) {
			return true;
		} else {
			return false;
		}
	}
}