package ca.mcgill.ecse321.TAMAS.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Date;
import java.sql.Time;

public class Login {
	private static String user = "wzs1234566";
	private static String password = "yuwen120";
	private static String myDriver = "org.gjt.mm.mysql.Driver";
	private static String myUrl = "jdbc:mysql://test.cabyhhnybi2l.us-west-2.rds.amazonaws.com/test";

	public static void main(String[] args) {
		ResultSet rs = getDB("login");
		String name="Jackson";
		try {
			while (rs.next()) {

				String r = rs.getString("login where Name='"+name+"'");
				System.out.println(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ResultSet getDB(String q) {
		try {
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, user, password);
			String query = "SELECT * FROM ";
			query += q;
			Statement st = conn.createStatement();
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			return rs;
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return null;
	}

	private static void updateDB(String q) {
		try {
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, user, password);
			Statement st = conn.createStatement();
			st.executeUpdate(q);
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
