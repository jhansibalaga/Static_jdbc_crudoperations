package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class creation{
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
        		  String sql = "create table "+sc.next() + "(id int, name varchar(20), email varchar(50))";
        		  pmst=conn.prepareStatement(sql);
        		  int i = pmst.executeUpdate();
        		  if(i==0) {
        			  System.out.println("inserted");
        		  }
        		  else {
        			  System.out.println("error");
        		  }
        		  pmst.close();
        		  conn.close();
        		  sc.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	  
          }
}
