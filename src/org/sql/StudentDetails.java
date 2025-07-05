package org.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDetails {
	
	static Connection con;
	
	private static void getDetails() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
			
			//String q = "query";
			String q = "SELECT * FROM employees";

			PreparedStatement p = con.prepareStatement(q);
			
			ResultSet  r= p.executeQuery();
			
			while(r.next()) {
				String b= r.getString("first_name");
				System.out.println(b);
			}
			
		} catch ( ClassNotFoundException |SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//retriveData("select * from employees");
		getDetails(); 
		
		System.out.println("b");
		System.out.println("q");

	}

}
