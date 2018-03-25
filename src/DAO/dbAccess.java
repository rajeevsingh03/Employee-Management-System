package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbAccess {

		static Connection con=null;
	    public static Connection getConnection()
	    {
	        if (con != null) return con;
	        String url = "jdbc:mysql://localhost:3306/term_project";
			String username = "root";
			String password = "root";
	        return getConnection(url, username, password);
	    }

	    private static Connection getConnection(String url,String username,String password)
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	           
	            con=DriverManager.getConnection(url, username, password);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	        return con;        
	    }
	}
