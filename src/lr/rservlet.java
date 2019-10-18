package lr;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class rservlet
 */
@WebServlet("/rservlet")
public class rservlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String m=request.getParameter("name");
		String n=request.getParameter("email");
		String o=request.getParameter("password");
		
		
		if(m==null || n==null || o==null)
		{
		RequestDispatcher rr=request.getRequestDispatcher("rhtml.jsp");
		rr.include(request, response);}
		else
		{
		     try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection myconn=DriverManager.getConnection("jdbc:mysql://Localhost:3306/Recycle","root","coding");
		     // Statement mystmt=myconn.createStatement();
			//	ResultSet myrs=mystmt.executeQuery("select count(*) from user");
		   
					PreparedStatement ps=myconn.prepareStatement("insert into user values(?,?,?)");
		      
				ps.setString(1,m);
		      
		    ps.setString(2,n);
		     ps.setString(3,o);
		      ps.executeUpdate();
		      RequestDispatcher rr=request.getRequestDispatcher("shakti.jsp");
				rr.forward(request, response);
					
		     }
		
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}}
	}
}