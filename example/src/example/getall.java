package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getall{
	 public static final String Driver="com.mysql.cj.jdbc.Driver";
	 public static final String username="root";
	 public static final String password="root";
	 public static final String url="jdbc:mysql://localhost:3306/sys";
	 public static Connection conn;
	 public static PreparedStatement pmst;
	 	 
          public static void main(String[] args) {
        	  Scanner sc = new Scanner(System.in);
        	  try {
        		  Class.forName(Driver);
        		  conn = DriverManager.getConnection(url, username, password);
        		  System.out.println("enter table name");
        		  String sql = "select * from "+sc.next();
        		  pmst=conn.prepareStatement(sql);
        		  ResultSet rs = pmst.executeQuery();
        		  while(rs.next()) {
        			  
        		  
        		  System.out.println("emp_id"+rs.getInt("emp_id")+"emp_name"+
        		  rs.getString("emp_name")+rs.getString("emp_email"));
        		  }
        		  pmst.close();
        		  conn.close();
        		  sc.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	  
          }
}
