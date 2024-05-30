package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jfs {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String username = "root";
	public static final String password = "root";
	public static final String url = "jdbc:mysql://localhost:3306/?user=root";
	public static Connection conn;
	public static PreparedStatement pmst;
	
	public static void main(String[] args) {
		try {
			Scanner src = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "drop database "+ src.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("successfully deleted");
			}
			else {
				System.out.println("error");
			}
			pmst.close();
			conn.close();
			src.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}

