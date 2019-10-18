package lr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Userdao
{ public static boolean validate(String email,String password)
	{
	boolean status=false;
	try {
		 Class.forName("com.mysql.jdbc.Driver");
			Connection myconn=DriverManager.getConnection("jdbc:mysql://Localhost:3306/Recycle","root","coding");
	      PreparedStatement ps=myconn.prepareStatement("select * from user where email=? and password=?");
	      ps.setString(1,email);
	      ps.setString(2,password);
	      ResultSet rs=ps.executeQuery();
	      status=rs.next();
	      
	      
	} catch(Exception e)
	{System.out.println(e);}
	return status;
	}
}