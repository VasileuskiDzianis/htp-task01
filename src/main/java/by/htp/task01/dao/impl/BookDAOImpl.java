package by.htp.task01.dao.impl;

import java.sql.*;
import java.util.*;

import by.htp.task01.dao.*;
import by.htp.task01.dao.connection.ConnectionPool;
import by.htp.task01.dao.exception.*;
import by.htp.task01.domain.Book;

public class BookDAOImpl implements BookDAO {

	private ConnectionPool connectionPool;

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addNewBook(String title, String author, String genre, String year, int quantity) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_BOOK);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, genre);
			preparedStatement.setString(4, year);
			preparedStatement.setInt(5, quantity);
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
	public void addEditBook(String title, String genre, String author, String year, int quantity, int idBook)
			throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_BOOK);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, genre);
			preparedStatement.setString(4, year);
			preparedStatement.setInt(5, quantity);
			preparedStatement.setInt(6, idBook);
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
			resultSet = statement.executeQuery(SQLCommand.SELECT_BOOK);

			booklist = new ArrayList<Book>();
			Book book = null;

			while (resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt(ColumnLabel.BOOK_ID));
				book.setTitle(resultSet.getString(ColumnLabel.BOOK_TITLE));
				book.setAuthor(resultSet.getString(ColumnLabel.BOOK_AUTHOR));
				book.setGenre(resultSet.getString(ColumnLabel.BOOK_GENRE));
				book.setYear(resultSet.getString(ColumnLabel.BOOK_YEAR));
				book.setQuantity(resultSet.getInt(ColumnLabel.BOOK_QUANTITY));
				book.setStatus(resultSet.getBoolean(ColumnLabel.BOOK_STATUS));
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
