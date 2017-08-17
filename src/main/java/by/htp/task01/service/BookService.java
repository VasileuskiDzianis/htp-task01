package by.htp.task01.service;

import java.util.List;

import by.htp.task01.domain.Book;
import by.htp.task01.service.exception.ServiceException;

public interface BookService {
	
	void addNewBook(Book book) throws ServiceException;
	void addEditBook(Book book) throws ServiceException;
	List<Book> getBookList();
}
