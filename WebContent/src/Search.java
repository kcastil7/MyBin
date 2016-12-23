

import java.io.IOException;
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

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search").replace(" ", ""); 
		String reset = request.getParameter("Reset");
		List<Locator> locator = new ArrayList<Locator>();
		String getLocations = "";
		if (reset != null)
		{
			request.removeAttribute("Reset");
			response.sendRedirect("Home");
		}
		else
		{
			Connection c = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {

				String url = "jdbc:mysql://cs3.calstatela.edu/cs4961stu03";
				String db_user = "cs4961stu03";
				String db_pass = "bk2lVKkH";


				c = DriverManager.getConnection(url, db_user, db_pass);

				getLocations = "select * from Locator where ItemNumber = ? OR Location = ?";
				pstmt = c.prepareStatement(getLocations);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				rs = pstmt.executeQuery();
				while (rs.next()) 
				{
					int id = rs.getInt("ID");
					String itemnumber = rs.getString("ItemNumber");
					String po = rs.getString("PO");
					String location = rs.getString("Location");
					int amount = rs.getInt("Amount");
					String username2 = rs.getString("UserName");
					String type = rs.getString("Type");

					Locator newLocator = new Locator(id,itemnumber,po,location,amount,username2,type);
					locator.add(newLocator);



				}
				request.setAttribute("locator",locator);
				pstmt.close();
				rs.close();
				c.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/WEB-INF/Home.jsp?")
			.forward(request, response);
		}

	}
}
