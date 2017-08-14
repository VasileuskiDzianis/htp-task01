package by.htp.task01.dao.impl;

import java.sql.*;

import by.htp.task01.dao.*;
import by.htp.task01.dao.connection.ConnectionPool;
import by.htp.task01.dao.exception.*;
import by.htp.task01.domain.User;

public class UserDAOImpl implements UserDAO {
	private static final String INSERT_USER_REQUEST = "INSERT INTO user (u_login, u_password) VALUES (?,?)";
	private static final String SELECT_USER_BY_LOGIN_PASSWORD_REQUEST = "SELECT u_id, u_login, u_password FROM user WHERE u_login = ? AND u_password = ?";

	private static final String USER_ID_FIELD = "u_id";

	private ConnectionPool connectionPool;

	public void setConnectionPool(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void signIn(User user) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN_PASSWORD_REQUEST);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt(USER_ID_FIELD));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_id_by_login_password'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement, resultSet);
		}
	}

	@Override
	public void signUp(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.take();
			preparedStatement = connection.prepareStatement(INSERT_USER_REQUEST);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem with connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'insert_user'", e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}
}
