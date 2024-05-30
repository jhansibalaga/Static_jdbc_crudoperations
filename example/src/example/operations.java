package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class operations {
	 public static final String Driver="com.mysql.cj.jdbc.Driver";
	 public static final String username="root";
	 public static final String password="root";
	 public static final String url="jdbc:mysql://localhost:3306/sys";
	 public static Connection conn;
	 public static PreparedStatement pmst;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			display();
			System.out.println("enter your choice");
			ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1: createdatabase();
			break;
			case 2: createtable();
			break;
			case 3: insertion();
			break;
			case 4: deletion();
			break;
			case 5: getall();
			break;
			case 6: getbyid();
			break;
			case 7: droptable();
			break;
			case 8: dropdatabase();
			break;
			case 9: updatetable();
			break;
			case 10: 
			  System.exit(0);						
			default:
				System.out.println("invalid choice");
			}
		} while (ch>0);
		
		
	}
	private static void updatetable() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/first";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "update "+sc.next()+" set name = ? , email = ? where id = ? ";
			pmst = conn.prepareStatement(sql);
			pmst = conn.prepareStatement(sql);			
			System.out.println("enter table1 name");
			pmst.setString(1,sc.next());
			System.out.println("enter table1 email");
			pmst.setString(2,sc.next());
			System.out.println("enter table1 id");
			pmst.setInt(3,sc.nextInt());
			int i = pmst.executeUpdate();		
			if(i>0) {
				System.out.println("successfully updated");
			}
			else {
				System.out.println("error");
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void dropdatabase() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("database dropped");
			}
			else {
				System.out.println("error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void droptable() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/sample";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "drop table "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("successfully dropped");
			}
			else {
				System.out.println("error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void getbyid() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/first";
		 try {
   		  Class.forName(Driver);
   		  conn = DriverManager.getConnection(url, username, password);
   		  String sql = "select * from table1 where id = ?";
   		  pmst=conn.prepareStatement(sql);
   		  System.out.println("enter table1 id");
   		  pmst.setInt(1, sc.nextInt());   		  
   		  ResultSet rs = pmst.executeQuery();
   		  while(rs.next()) {
   			  
   		  
   		  System.out.println("id"+rs.getInt("id")+"name"+
   		  rs.getString("name")+rs.getString("email"));
   		  }
//   		  pmst.close();
//   		  conn.close();
//   		  sc.close();
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
   	  
		
	}
	private static void getall() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/first";
		 try {
   		  Class.forName(Driver);
   		  conn = DriverManager.getConnection(url, username, password);
   		  System.out.println("enter table name");
   		  String sql = "select * from "+sc.next();
   		  pmst=conn.prepareStatement(sql);
   		  ResultSet rs = pmst.executeQuery();
   		  while(rs.next()) {
   			  
   		  
   		  System.out.println("id"+rs.getInt("id")+"name"+
   		  rs.getString("name")+rs.getString("email"));
   		  }
//   		  pmst.close();
//   		  conn.close();
//   		  sc.close();
//			
		} catch (Exception e) {
			e.printStackTrace();
		}
   	  
		
		
		
	}
	private static void deletion() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/first";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from table1 where id = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter table1 id");
			pmst.setInt(1,sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("successfully deleted");
			}
			else {
				System.out.println("error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void insertion() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/first";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into table1(id,name,email) values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter table1 id");
			pmst.setInt(1,sc.nextInt());
			System.out.println("enter table1 name");
			pmst.setString(2,sc.next());
			System.out.println("enter table1 email");
			pmst.setString(3,sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("successfully inserted");
			}
			else {
				System.out.println("error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void createtable() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/sample";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "create table "+sc.next()+ "(id int,name varchar(20),email varchar(50))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("successfully created");
			}
			else {
				System.out.println("error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	private static void createdatabase() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "create database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("database created");
			}
			else {
				System.out.println("error");
			}
//			pmst.close();
//			conn.close();
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void display() {
		System.out.println("operations");
		System.out.println("\t1 .create database");
		System.out.println("\t2 .create table");
		System.out.println("\t3 .insertion of data");
		System.out.println("\t4 .deletion of data");
		System.out.println("\t5 .fetch all records");
		System.out.println("\t6 .get record by id");
		System.out.println("\t7 .delete database");
		System.out.println("\t9 .process is terminated");
		
	}
}
