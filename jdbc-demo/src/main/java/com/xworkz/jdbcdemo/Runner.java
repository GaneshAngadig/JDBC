package com.xworkz.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		insertMovie();
		updateMovie();
		deleteMovie();
	}

	private static void insertMovie() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter movie id");
		int id=sc.nextInt();
		
		System.out.println("enter movie name");
		String name=sc.next();
		
		System.out.println("enter movie rating");
		double rate=sc.nextDouble();
		
		System.out.println("enter movie language");
		String lang=sc.next();
		
		System.out.println("enter movie budget");
		long budget=sc.nextLong();
		
		Statement statement=null;
		Connection connection=null;
		try {
			
			//step1
			//Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded");
			
			//step2
			//Create Connection (Establish connection with MySQL Server)
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			System.out.println("Connection created");
			
			//step3
			//create platform/environment to execute the queries
			 statement=connection.createStatement();
			System.out.println("Statement created");
			
			//step4
			//execute the query
			statement.execute("Insert into movie values(("+id+"),('"+name+"'),("+rate+"),('"+lang+"'),("+budget+"))");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			//step6
			//close the costly resources
			try {
				if(statement !=null)
					statement.close();
				if(connection !=null)
					connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	private static void updateMovie() {
		Scanner sc=new Scanner(System.in);
		
	
		
		System.out.println("enter movie name to update");
		String name=sc.next(); 
		
		System.out.println("enter movie rating to update");
		double rate=sc.nextDouble();
		
		System.out.println("enter movie language");
		String lang=sc.next();
		
		System.out.println("enter movie budget");
		long budget=sc.nextLong();
		
		System.out.println("enter movie id to update");
		int id=sc.nextInt();
		
		Statement statement=null;
		Connection connection=null;
		try {	
		
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			
			System.out.println("connected");
			
			statement=connection.createStatement();
			System.out.println("satement created");
			
			statement.execute("UPDATE movie SET name=('"+name+"'),rating=("+rate+"), language=('"+lang+"'),budget=("+budget+") where id=("+id+")");
			System.out.println("successfully updated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			//step6
			//close the costly resources
			try {
				if(statement !=null)
					statement.close();
				if(connection !=null)
					connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	private static void deleteMovie() {
		Scanner sc=new Scanner(System.in);

		
		System.out.println("enter movie id to delte all details");
		int id=sc.nextInt();
		
		Statement statement=null;
		Connection connection=null;
		try {	
		
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jan06", "root", "root");
			
			System.out.println("connected");
			
			statement=connection.createStatement();
			System.out.println("satement created");
			
			statement.execute("DELETE FROM movie WHERE id=("+id+")");
			System.out.println("successfully deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			//step6
			//close the costly resources
			try {
				if(statement !=null)
					statement.close();
				if(connection !=null)
					connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
//execute vs executeupdate vs execute query
