

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init( ServletConfig config ) throws ServletException
	{
		super.init( config );

		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new ServletException( e );
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		List<Locator> locator = new ArrayList<Locator>();
		String getLocations = "";


		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs4961stu03";
			String db_user = "cs4961stu03";
			String db_pass = "bk2lVKkH";


			c = DriverManager.getConnection(url, db_user, db_pass);

			getLocations = "select * from Locator where ID = ?";
			pstmt = c.prepareStatement(getLocations);
			pstmt.setInt( 1, id );
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				int id2 = rs.getInt("ID");
				String itemnumber = rs.getString("ItemNumber");
				String po = rs.getString("PO");
				String location = rs.getString("Location");
				int amount = rs.getInt("Amount");
				String username2 = rs.getString("UserName");
				String type = rs.getString("Type");

				Locator newLocator = new Locator(id2,itemnumber,po,location,amount,username2,type);
				locator.add(newLocator);		


			}
			request.setAttribute("Edit",locator);
			pstmt.close();
			rs.close();
			c.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		//request.setAttribute( "Edit", entry );
		request.getRequestDispatcher( "/WEB-INF/Edit.jsp" ).forward(
				request, response );
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
				String insert_user = "update Locator set ItemNumber = ?, PO = ?, Location = ?, Amount = ?, Type  = ? where ID = ?";
				pstmt2 = c.prepareStatement(insert_user);
				pstmt2.setString(1, itemnumber);
				pstmt2.setString(2, po);
				pstmt2.setString(3, location);
				pstmt2.setInt(4, Integer.parseInt(qty));
				pstmt2.setString(5, "OverFlow");
				pstmt2.setInt(6, id);

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
