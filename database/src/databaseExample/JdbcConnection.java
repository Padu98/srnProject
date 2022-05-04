package databaseExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	private final String url = "jdbc:postgresql://localhost:5432/jan_testdb";
	private final String user = "jan";
	private final String password = "1234";

	private void doMain(String[] args) {
		connect();
	}

	private void connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			if(connection != null) {
				System.out.println("Connected to postresql server succesfully!");
			}
			else {
				System.out.println("Connected to postresql server failed!");
			}
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from vornamen");
			while(resultSet.next()) {
				System.out.format("id: %d vorname: %s\n", resultSet.getInt(1), resultSet.getString(2));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JdbcConnection jdbcConnection = new JdbcConnection();
		jdbcConnection.doMain(args);
	}	

}
