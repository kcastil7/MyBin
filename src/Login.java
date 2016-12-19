import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    
 public void init() throws ServletException {
		
	 if(getServletContext().getAttribute( "Users" ) == null)
	 {
		ArrayList<User> users = new ArrayList<User>();
		
		// Pre-populate the users list with some dummy data
		
		// Add the array of Users to the global scope
		this.getServletContext().setAttribute("Users", users);
	 }
		
	}


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Login.jsp?")
		.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String error = "";
		boolean pass = false;
		
		
		if (username.isEmpty())
		{
			request.getSession().setAttribute("errorMessage", "You must enter a username");
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		}
		if (password.isEmpty())
		{
			request.getSession().setAttribute("errorMessage", "You must enter a password");
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs4961stu03";
			String db_user = "cs4961stu03";
			String db_pass = "bk2lVKkH";

			c = DriverManager.getConnection(url, db_user, db_pass);
			String search_user = "select * from Users where UserName = ?";
			pstmt = c.prepareStatement( search_user );
			pstmt.setString( 1, username );

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				if(rs.getString("UserName").equals(username))
				{
					if(rs.getString("Password").equals(password))
					{
						pass = true;
					}
					else 
					{
						error = "Invalid login";
					}
				}
				else 
				{
					error = "Invalid login";
				}
			}
			
			pstmt.close();
			rs.close();
			c.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(!pass){
			request.getSession().setAttribute("errorMessage", "invalid Login");
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		}
		

		else 
		{
			
			request.getSession().setAttribute("username", username);
			response.sendRedirect("Home");
		}
	}
		 

	}

