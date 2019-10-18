package lr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet idmplementation class userservlet
 */
@WebServlet("/userservlet")
public class userservlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("unused")
	private userdb userd;
    @Resource(name="jdbc/user")
    private DataSource datasource;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try { userd=new userdb(datasource);
		}
		catch(Exception e)
		{ throw new ServletException(e);
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
         
         PrintWriter out=response.getWriter();
        
         
    String x=request.getParameter("email");
         String y=request.getParameter("password");
         if(x==null || y==null)
         {
        	 RequestDispatcher r=request.getRequestDispatcher("index.jsp");
        	 r.include(request, response);
         }
         else if(Userdao.validate(x,y))
         { RequestDispatcher rd=request.getRequestDispatcher("welcomeservlet");
         rd.forward(request,response);
         }
         else { try {
        	 out.print(" sign up kar");
        	 RequestDispatcher rs=request.getRequestDispatcher("rservlet");
        	 rs.forward(request, response);
        	 
         out.close();}
           catch(Exception e)
           { System.out.println(e);
           }
	}
}}
         
	

