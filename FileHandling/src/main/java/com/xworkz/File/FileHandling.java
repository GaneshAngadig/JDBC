package com.xworkz.File;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileHandling {
	
		public static void main(String args[]) throws Exception {
			String query = "INSERT INTO application(application_name) VALUES (?)";

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/jan06", "root", "root");

				System.out.println("Connection established......");

				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "application_name");

				FileReader reader = new FileReader("C:\\Users\\cheta\\OneDrive\\Desktop\\JDBC work space\\git-jdbc\\application.txt");
				
				pstmt.setCharacterStream(1, reader);

				pstmt.execute();

				System.out.println("Data inserted......");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


