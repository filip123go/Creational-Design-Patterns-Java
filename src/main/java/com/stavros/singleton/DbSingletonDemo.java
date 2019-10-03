package com.stavros.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {
	public static void main(String[] args) {
		DbSingleton instance = DbSingleton.getInstance();

		long timeBefore = 0;
		long timeAfter = 0;

		System.out.println(instance);

		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore); //count the time needed to establish connection

		Statement sta;
		try {
			sta = conn.createStatement();
			int count = sta.executeUpdate("CREATE TABLE address(ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
			System.out.println("Table created");
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore); //count the time needed to establish connection, here its 0 because its optimized to return the same connection
	}
}
