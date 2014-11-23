package com.ibm.parkease.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.ibm.db2.jcc.DB2SimpleDataSource;
import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;


public class DBUtil {

	private static Connection connection = null;

	static {

		String databaseHost = "localhost";
		String databaseName = "parkease";
		int port = 50001;
		String user = "db2admin";
		String password = "db2admin";
		String url = null;
		String databaseUrl = null;

		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		  try {
			if (VCAP_SERVICES != null) {
			        BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
			        String thekey = null;
			        Set<String> keys = obj.keySet();
			        for (String eachkey : keys) {
			      	       if (eachkey.toUpperCase().contains("SQLDB"))
			         				      thekey = eachkey;
			              }
			        System.out.println("KEY :"+thekey);
			         BasicDBList list = (BasicDBList) obj.get(thekey);
			         obj = (BasicDBObject) list.get("0");
			         obj = (BasicDBObject) obj.get("credentials");
			         databaseHost = (String) obj.get("host");
			         databaseName = (String) obj.get("db");
			         port = (int) obj.get("port");
			         user = (String) obj.get("username");
			         password = (String) obj.get("password");
			         url = (String) obj.get("jdbcurl");
			         

						DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
				        dataSource.setServerName(databaseHost);
				        dataSource.setPortNumber(port);
				        dataSource.setDatabaseName(databaseName);
				        dataSource.setUser(user);
				        dataSource.setPassword (password);
				        dataSource.setDriverType(4);
				        connection=dataSource.getConnection();
				        connection.setAutoCommit(true);
			         
			   } else {
			         // Use the jdbcurl or construct your own
			         databaseUrl = "jdbc:db2://" + databaseHost + ":" + port + "/" + databaseName;
						Class.forName("com.ibm.db2.jcc.DB2Driver");
						connection = DriverManager.getConnection("jdbc:db2:L_408893","db2admin","db2admin");		         
			  }


			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;

	}

	public static Statement getStatement() throws SQLException {
		Connection connection = DBUtil.getConnection();
		Statement stmt = connection.createStatement();
		
		return stmt;
	}

}
