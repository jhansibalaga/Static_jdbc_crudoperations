package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
        		  String sql = "insert into employee3(emp_id,emp_name,emp_email) value(?,?,?)";
        		  pmst=conn.prepareStatement(sql);
        		  System.out.println("enter employee3 id");
        		  pmst.setInt(1,sc.nextInt());
        		  System.out.println("enter employee3 name");
        		  pmst.setString(2,sc.next());     		
        		  System.out.println("enter employee3 email");
        		  pmst.setString(3,sc.next());   
        		  int i = pmst.executeUpdate();
        		  if(i>0) {
        			  System.out.println("inserted successfully");
        		  }
        		  else {
        			  System.out.println("error");
        		  }
        		  sc.close();
        		  conn.close();
        		  pmst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	  
          }
}
