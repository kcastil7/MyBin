

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Connection c = null;
		PreparedStatement pstmt = null;
		String deleteLocations = "";
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs4961stu03";
			String db_user = "cs4961stu03";
			String db_pass = "bk2lVKkH";
		

			c = DriverManager.getConnection(url, db_user, db_pass);
			
			deleteLocations = "DELETE FROM Locator where ID = ?";
			pstmt = c.prepareStatement(deleteLocations);
			pstmt.setInt( 1, id );
			pstmt.executeUpdate();
			pstmt.close();
			c.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Home")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
