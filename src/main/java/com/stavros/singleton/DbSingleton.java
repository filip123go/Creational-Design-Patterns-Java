package com.stavros.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

	private static volatile DbSingleton instance = null;//volatile helps the Singleton to stay thread safe
	private static volatile Connection conn;

	private DbSingleton() {
		try{
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		}catch (SQLException e){
			e.printStackTrace();
		}

		if (conn !=null){
			throw new RuntimeException("Use getConnection() method to create");
		}

		if (instance != null){
			throw new RuntimeException("Use getInstance() method to create");
		}
	}


	public static DbSingleton getInstance() { //we could do the entire method synchronized but it leads in bad performance
		if (instance == null) {
			synchronized (DbSingleton.class) { //thread safe
				if (instance == null) { // lazy load
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}

	public Connection getConnection(){
		if (conn == null){
			synchronized (DbSingleton.class){
				if (conn == null){
					try{
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";

						conn = DriverManager.getConnection(dbUrl);
					}catch (SQLException e){
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}