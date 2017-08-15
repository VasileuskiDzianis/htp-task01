package by.htp.task01.dao.connection;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import by.htp.task01.dao.exception.*;

public final class ConnectionPool {
	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
	
	private static final int DEFAULT_POOL_SIZE = 5;

	private BlockingQueue<Connection> freeConnection;
	private BlockingQueue<Connection> busyConnection;

	private int poolSize;
	private String driver;
	private String user;
	private String password;
	private String url;

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private ConnectionPool() {

	}

	public void init() throws ConnectionPoolException {
		
		if (poolSize == 0) {
			poolSize = DEFAULT_POOL_SIZE;
		}
		
		freeConnection = new ArrayBlockingQueue<Connection>(poolSize);
		busyConnection = new ArrayBlockingQueue<Connection>(poolSize);

		try {
			Class.forName(driver);
			for (int i = 0; i < poolSize; i++) {
				freeConnection.add(DriverManager.getConnection(url, user, password));
			}
			LOGGER.debug("Spring initializes ConnectionPool");
		} catch (ClassNotFoundException e) {
			throw new ConnectionPoolException("Can't find database driver class", e);
		} catch (SQLException e) {
			throw new ConnectionPoolException("SQLException in ConnectionPool", e);
		}

	}

	public Connection take() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = freeConnection.take();
			busyConnection.put(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data source", e);
		}
		return connection;
	}

	public void free(Connection connection) throws InterruptedException, DAOException {
		if (connection == null) {
			throw new DAOException("Connection is null");
		}

		Connection tempConnection = connection;
		connection = null;
		busyConnection.remove(tempConnection);
		freeConnection.put(tempConnection);
	}

	public void close() throws IOException {
		List<Connection> listConnection = new ArrayList<Connection>();
		listConnection.addAll(this.busyConnection);
		listConnection.addAll(this.freeConnection);

		for (Connection connection : listConnection) {
			try {
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
		LOGGER.debug("Spring destroys ConnectionPool");
	}

	public void closeConnection(Connection con, Statement st, PreparedStatement preSt, ResultSet rs) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (preSt != null) {
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}

	public void closeConnection(Connection con, PreparedStatement preSt) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (preSt != null) {
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}

	public void closeConnection(Connection con, ResultSet rs) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st, PreparedStatement preSt) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (preSt != null) {
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

	}

	public void closeConnection(Connection con, PreparedStatement preSt, ResultSet rs) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (preSt != null) {
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}

	public void closeConnection(Connection con, Statement st, ResultSet rs) {
		if (con != null) {
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Connection Pool Exception occur, ", e);
			}
		}
	}
}
