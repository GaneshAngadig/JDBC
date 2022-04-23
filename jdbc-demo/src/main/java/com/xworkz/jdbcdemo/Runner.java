package com.xworkz.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Runner {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

//		insertMovie();
//		updateMovie();
//		deleteMovie();
//		
		MovieDAO movieDAO = new MovieDAO();
		//movieDAO.getNameByMovieId();
		//System.out.println("get movie name By Id");
		//int id = sc.nextInt();
		movieDAO.getAll();
		//System.out.println("get language and budget by movie name");
		//String nam=sc.next();
		//movieDAO.getLanguageAndBudgetByName(nam);
		
	}

	private static void insertMovie() {


		System.out.println("enter movie id");
		int id = sc.nextInt();

		System.out.println("enter movie name");
		String name = sc.next();

		System.out.println("enter movie rating");
		double rate = sc.nextDouble();

		System.out.println("enter movie language");
		String lang = sc.next();

		System.out.println("enter movie budget");
		long budget = sc.nextLong();

		Statement statement = null;
		Connection connection = null;
		try {

			// step1
			// Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded");

			// step2
			// Create Connection (Establish connection with MySQL Server)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			System.out.println("Connection created");

			// step3
			// create platform/environment to execute the queries
			statement = connection.createStatement();
			System.out.println("Statement created");

			// step4
			// execute the query
			statement.execute("Insert into movie values((" + id + "),('" + name + "'),(" + rate + "),('" + lang + "'),("
					+ budget + "))");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private static void updateMovie() {

		System.out.println("enter movie name to update");
		String name = sc.next();

		System.out.println("enter movie rating to update");
		double rate = sc.nextDouble();

		System.out.println("enter movie language");
		String lang = sc.next();

		System.out.println("enter movie budget");
		long budget = sc.nextLong();

		System.out.println("enter movie id to update");
		int id = sc.nextInt();

		Statement statement = null;
		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			System.out.println("connected");

			statement = connection.createStatement();
			System.out.println("satement created");

			statement.execute("UPDATE movie SET name=('" + name + "'),rating=(" + rate + "), language=('" + lang
					+ "'),budget=(" + budget + ") where id=(" + id + ")");
			System.out.println("successfully updated");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private static void deleteMovie() {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter movie id to delte all details");
		int id = sc.nextInt();

		Statement statement = null;
		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			System.out.println("connected");

			statement = connection.createStatement();
			System.out.println("satement created");

			statement.execute("DELETE FROM movie WHERE id=(" + id + ")");
			System.out.println("successfully deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			sc.close();
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
	public void getMovieNameByMovieId() {

		System.out.println("enter movie id get movie name");
		int id = sc.nextInt();

		String query = "SELECT mv.name FROM movie mv WHERE id=(" + id + ")";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			statement = connection.createStatement();

//			step 5
//			Processing the result set
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String movieName = resultSet.getString("name");
				System.out.println("movie name:" + movieName);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	
	public void getAll() {

		String query = "SELECT * FROM movie ";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan6", "root", "root");

			statement = connection.createStatement();

//			step 5
//			Processing the result set
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				System.out.println("id:" + resultSet.getInt("id"));
				System.out.println("name:" + resultSet.getString("name"));
				System.out.println("rating:" + resultSet.getDouble("rating"));
				System.out.println("langauge:" + resultSet.getString("language"));
				System.out.println("budget:" + resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private Properties loadPropertiesFile() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void getLanguageAndBudgetByMovieName(String movieName) {
		String query = "SELECT language,budget FROM movie where name=('" + movieName + "')";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");

			statement = connection.createStatement();

//			step 5
//			Processing the result set
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				System.out.println("langauge:" + resultSet.getString("language"));
				System.out.println("budget:" + resultSet.getLong("budget"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
//execute vs executeupdate vs execute query
