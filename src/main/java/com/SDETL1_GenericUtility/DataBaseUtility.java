package com.SDETL1_GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.Segment;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	static  Connection connection;
	static  Statement statement;

/**
 * this method is used to open the database connection and intialize the connection,statement
 * 
 * 
 * @param dbUrl
 * @param dbUsername
 * @param dbPassword
 * @throws SQLException
 */
public static void openDBconnection( String dbUrl,String dbUsername, String dbPassword) throws SQLException {
	 Driver d = new Driver();
	 DriverManager.registerDriver(d);
	 connection=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
	 statement=connection.createStatement();
	 
}
/**
 * this method is used to fetch the data from database/to do the DQL actions on database
 * 
 * @param query
 * @param coloumnname
 * @return
 * @throws SQLException
 */
public static ArrayList<String> getDataFromdataBase(String query,String coloumnname) throws SQLException{
	ArrayList<String> list=new ArrayList<>();
	ResultSet result = statement.executeQuery(query);
	while(result.next())
	{
		list.add(result.getString(coloumnname));
	}
	return list;
}
/**
 * this method is used to validate the data whether it is present in database or not
 * 
 * @param query
 * @param coloumnname
 * @param expecteddata
 * @return
 * @throws SQLException
 */

public static boolean valiateDatainDatabase(String query, String coloumnname, String expecteddata) throws SQLException {
	ArrayList<String> list=getDataFromdataBase(query, coloumnname);
	boolean flag = false;
	for(String actualData:list)
	{
		if(actualData.equalsIgnoreCase(expecteddata)) {
			flag=true;
			break;
		}
	}
	return flag;
}
/**
 * this method is used to store/modify/insert/delete/ the data in database/to do the DML and DDL actions on database
 * 
 * @param query
 * @throws SQLException
 */

public static void setDataIndataBase(String query) throws SQLException {
	int result = statement.executeUpdate(query);
	if(result>=1)
	{
	System.out.println("Data entered / modified successfully");	
	}	

}


public static void closeDBconnect() {
	try {
		connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closing the DataBase connection we got exception");
		}

}
}