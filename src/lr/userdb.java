package lr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import javax.sql.DataSource;

public class userdb {
	public userdb(DataSource theDataSource)
	{
	
	}
	public static List<usera> getUsers() throws Exception
	{ List<usera> users = new ArrayList<>();
	Connection myconn=null;
	Statement mystmt=null;
	ResultSet myrs=null;
	try
	{   Class.forName("com.mysql.jdbc.Driver");
		myconn=DriverManager.getConnection("jdbc:mysql://Localhost:3306/Recycle","root","coding");
		String sql="select * from users";
		mystmt=myconn.createStatement();
		myrs=mystmt.executeQuery(sql);
		while(myrs.next())
		{ String name=myrs.getString("name");
	      String email=myrs.getString("email");
	      int password=myrs.getInt("password");
	      
	      usera tempuser=new usera(name,email,password);
	      users.add(tempuser);
	      
	
	
	
	}
		return users;
} finally
	{ close(myconn,mystmt,myrs);
	
	}
	
	
}
	private static void close(Connection myconn, Statement mystmt, ResultSet myrs) {
		// TODO Auto-generated method stub
		try { if(myrs!=null) {
			myrs.close();
		}
		if(mystmt!=null)
		{ mystmt.close();
		
		}
		if(myconn!=null)
		{ myconn.close();
		
		}
		}
		catch(Exception e)
		{ e.printStackTrace();
		}}}