package by.htp.task01.dao.impl;

import java.sql.*;

import by.htp.task01.dao.*;
import by.htp.task01.dao.connection.ConnectionPool;
import by.htp.task01.dao.exception.*;
import by.htp.task01.domain.User;

public class UserDAOImpl implements UserDAO {
	private static final String INSERT_USER = "INSERT INTO user (u_login, u_password) VALUES (?,?)";
	private static final String SELECT_USER_BY_LOGIN_PASSWORD = "SELECT u_id, u_login, u_password FROM user WHERE u_login = ? AND u_password = ?";
	
	private static final String USER_ID = "u_id";
	private static final String USER_LOGIN = "u_login";
	private static final String USER_PASSWORD = "u_password";
	
	private ConnectionPool connectionPool;

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public User signIn(String login, int password) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(USER_ID));
				user.setLogin(resultSet.getString(USER_LOGIN));
				user.setPassword(resultSet.getInt(USER_PASSWORD));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_id_by_login_password'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement, resultSet);
		}

		return user;
	}

	@Override
	public void signUp(String login, int password) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'insert_user'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}
}
