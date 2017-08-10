package by.htp.task01.dao;

import java.util.List;

import by.htp.task01.dao.exception.DAOException;
import by.htp.task01.domain.Book;

public interface BookDAO {
	void addNewBook(String title, String authro, String genre, String year, int quantity) throws DAOException;
	void addEditBook(String title, String genre, String author, String year, int quantity, int idBook) throws DAOException;
	List<Book> getBooklist() throws DAOException;
}
