package by.htp.task01.dao;

import java.util.List;

import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;

public interface BookDAO {
	void addNewBook(Book book) throws DAOException;
	void addEditBook(Book book) throws DAOException;
	List<Book> getBooklist() throws DAOException;
}
