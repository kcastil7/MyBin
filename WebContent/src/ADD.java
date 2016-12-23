

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ADD
 */
@WebServlet("/ADD")
public class ADD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/ADD.jsp?")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemnumber = request.getParameter("itemnumber").replace(" ", ""); 
		String po = request.getParameter("po").replace(" ", ""); 
		String location = request.getParameter("location").replace(" ", ""); 
		String qty = request.getParameter("qty").replace(" ", "");
		String uname = (String) request.getSession().getAttribute("username");
		if(itemnumber.isEmpty() || po.isEmpty() || location.isEmpty() || qty.isEmpty())
		{
			request.getSession().setAttribute("errorMessage", "You Must Fill In All Fields");
			request.getRequestDispatcher("/WEB-INF/ADD.jsp").forward(request, response);
		}
		else 
		{
			Connection c = null;
			PreparedStatement pstmt2 = null;
			try
			{
				String url = "jdbc:mysql://cs3.calstatela.edu/cs4961stu03";
				String db_user = "cs4961stu03";
				String db_pass = "bk2lVKkH";

				c = DriverManager.getConnection(url, db_user, db_pass);
				String insert_user = "insert into Locator (ItemNumber, PO, Location, Amount, UserName, Type) values(?, ?, ?, ?, ?, ?)";
				pstmt2 = c.prepareStatement(insert_user);
				pstmt2.setString(1, itemnumber);
				pstmt2.setString(2, po);
				pstmt2.setString(3, location);
				pstmt2.setInt(4, Integer.parseInt(qty));
				pstmt2.setString(5, uname);
				pstmt2.setString(6, "OverFlow");
				
				pstmt2.execute();

				pstmt2.close();
				c.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		response.sendRedirect("Home");
	}

}
