package Main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class MyServer extends AbstractServer {    
	Connection conn;
	
	public static void main(String[] args) {
		MyServer s = new MyServer(Main.port);
	}

	public MyServer(int port) {
		super(port);
		this.connectToDB();
		try {
			this.listen();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void connectToDB() {
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			this.conn = DriverManager.getConnection("jdbc:sqlserver://188.121.44.212:1433;databaseName=orel;", "orelDeepdivers", "1qaz2wsx");
			System.out.println("SQL Server Login Successful!");




		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		
		Statement stmt;
		try {
			
			stmt = conn.createStatement();
		ResultSet rs = null;
			rs = stmt.executeQuery("Select * From orelDeepdivers.Workers");
			while(rs.next())
				System.out.println(rs.getString(1));
			
		} catch (SQLException e) {e.printStackTrace();}
	}
}
