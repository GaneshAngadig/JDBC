package com.xworkz.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieDAO {
	public void getNameByMovieId() {
		String query = "SELECT mv.name FROM movie mv WHERE id=1";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost::3306/jan06", "root", "root");

			statement = connection.createStatement();

			// step5
			// processing the result set
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				// String moviename=resultSet.getString("name");
				String movieName = resultSet.getString(1);
				System.out.println("Movie name:" + movieName);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			// step6
			// close the costly resources
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
		}

	public void getAll() {
		String query = "SELECT * FROM movie";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost::3306/jan06", "root", "root");

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("movie name:" + resultSet.getString("name"));
				System.out.println("movie id:" + resultSet.getInt("id"));
				System.out.println("movie rating:" + resultSet.getDouble("rating"));
				System.out.println("movie language:" + resultSet.getString("language"));
				System.out.println("movie budget:" + resultSet.getLong("budget"));
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		finally {
			
			// step6
			// close the costly resources
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
		}

	public void getLanguageAndBudgetByName(String movieName) {
		String query = "SELECT language,budget FROM movie where name=('" + movieName + "')";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost::3306/jan06", "root", "root");

			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("movie language:" + resultSet.getString("language"));
				System.out.println("movie budget:" + resultSet.getLong("budget"));
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		finally {
			
			// step6
			// close the costly resources
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
}
	}
