package ru.zhmyd.yandex.application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CoonectionUtil {
	private static Connection connection;

	public static Connection getConnction() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		return connection;
	}
}
