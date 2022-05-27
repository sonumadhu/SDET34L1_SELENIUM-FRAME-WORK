package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class Databaseconnection10Test {
	static Connection connection;
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
		//step1:-Create object for implementation class
		
		Driver driver = new Driver();
		
		//step2:-Register the Driver with JDBC
		
		DriverManager.registerDriver(driver);
		
		//step3:-Establish the connection
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	 	
		//step:-4 Create the statement
		
		Statement statement = connection.createStatement();
		
		//step:-5 Execute the Query
		
		ResultSet result = statement.executeQuery("select * from sdet34l1");
		
		//step:-6 Validate
		
		while(result.next())
		{
		 System.out.println(result.getString(1));
		}
		
		}
		finally {
			
			//step:-7 close the connection
		
			connection.close();
			
		}

		
		}
}
