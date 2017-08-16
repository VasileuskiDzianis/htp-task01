package by.htp.task01.dao.impl;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.task01.dao.*;
import by.htp.task01.dao.connection.ConnectionPool;
import by.htp.task01.dao.exception.*;
import by.htp.task01.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	private static final String INSERT_BOOK = "INSERT INTO book (b_title, b_author, b_genre, b_year, b_quantity) VALUES (?,?,?,?,?)";
	private static final String UPDATE_BOOK = "UPDATE book SET b_title = ?, b_author = ?, b_genre = ?, b_year = ?, b_quantity = ? WHERE b_id = ?";
	private static final String SELECT_BOOK = "SELECT * FROM book";

	private static final String BOOK_ID = "b_id";
	private static final String BOOK_TITLE = "b_title";
	private static final String BOOK_AUTHOR = "b_author";
	private static final String BOOK_GENRE = "b_genre";
	private static final String BOOK_YEAR = "b_year";
	private static final String BOOK_QUANTITY = "b_quantity";
	private static final String BOOK_STATUS = "b_status";

	@Autowired
	private ConnectionPool connectionPool;

	@Override
	public void addNewBook(Book book) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(INSERT_BOOK);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getGenre());
			preparedStatement.setString(4, book.getYear());
			preparedStatement.setInt(5, book.getQuantity());
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'inser_book'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public void addEditBook(Book book) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(UPDATE_BOOK);
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getGenre());
			preparedStatement.setString(4, book.getYear());
			preparedStatement.setInt(5, book.getQuantity());
			preparedStatement.setInt(6, book.getId());
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'update_book'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public List<Book> getBooklist() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Book> booklist = null;

		try {
			connection = connectionPool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_BOOK);

			booklist = new ArrayList<Book>();
			Book book = null;

			while (resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt(BOOK_ID));
				book.setTitle(resultSet.getString(BOOK_TITLE));
				book.setAuthor(resultSet.getString(BOOK_AUTHOR));
				book.setGenre(resultSet.getString(BOOK_GENRE));
				book.setYear(resultSet.getString(BOOK_YEAR));
				book.setQuantity(resultSet.getInt(BOOK_QUANTITY));
				book.setStatus(resultSet.getBoolean(BOOK_STATUS));
				booklist.add(book);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_book'", e);
		} finally {
			connectionPool.closeConnection(connection, statement, resultSet);
		}
		return booklist;
	}
}
