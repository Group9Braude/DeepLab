package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.GeneralMessage;
import entities.Order;
import entities.Worker;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class MyServer extends AbstractServer {    
	Connection conn;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MyServer s1 = new MyServer(Main.port);
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


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("handleMessageFromClient");
		switch(((GeneralMessage)msg).actionNow){
		case "Login":
			runQuery((Worker)msg, client);break;
		case "IssueOrder":
			issueOrder((Order)msg, client);
		}
	}
	//PreparedStatement stmt = conn.prepareStatement("insert into x values(?, ?, ?)");

	public void issueOrder(Order order, ConnectionToClient client){
		System.out.println("issueorder server");
		PreparedStatement preparedStmt;
		Statement stmt;
		int max=0;
		try{
			preparedStmt = (PreparedStatement) conn.prepareStatement("insert into orelDeepdivers.Orders(OrderNum, CustID, Description, "
					+ "Date, Comments, Handled) values(?,?,?,?,?,?)");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(OrderNum) FROM OrelDeepdivers.Orders");
			rs.next();max=rs.getInt(1);
			max++;
			preparedStmt.setInt(1, max);
			preparedStmt.setString(2, order.getCustID());
			preparedStmt.setString(3, order.getDescription());
			preparedStmt.setString(4, order.getDate());
			preparedStmt.setString(5, order.getComments());
			preparedStmt.setInt(6, order.getHandled());
			preparedStmt.executeUpdate();
			client.sendToClient(order);
				
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void runQuery(Worker worker, ConnectionToClient client){
		Statement stmt;
		try {stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(worker.query);
		if(!rs.next()){
			worker.actionNow = "Incorrect";
			client.sendToClient(worker);
		}
		else{
			Worker w = new Worker(rs.getString(3), rs.getString(1),rs.getString(2), rs.getString(5), rs.getInt(4));
			w.actionNow = "Correct";
			Worker.setCurrentWorker(w);
			client.sendToClient(w);
		}
		}catch (SQLException | IOException e) {e.printStackTrace();}
	}























	public void connectToDB() {
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			this.conn = DriverManager.getConnection("jdbc:sqlserver://188.121.44.212:1433;databaseName=orel;", "orelDeepdivers", "1qaz2wsx");
			Statement stmt;
			try {

				stmt = conn.createStatement();
				ResultSet rs = null;

			} catch (SQLException e) {e.printStackTrace();}
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}

