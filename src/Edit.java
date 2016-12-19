

import java.io.IOException;
import java.util.List;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Locator getEntry( Integer id )
	{
		System.out.println("it gets the method");
		@SuppressWarnings("unchecked")
		List<Locator> entries =  (List<Locator>) getServletContext().getAttribute("locator");

		for( Locator entry : entries )
		{
			if( entry.getID() == id)
			{
				System.out.println("Its equal");
				return entry;
			}
		}
	System.out.println("Its not equal");
	return null;

}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	Locator entry = getEntry( id );
	request.setAttribute( "Edit", entry );
	request.getRequestDispatcher( "/WEB-INF/Edit.jsp" ).forward(
			request, response );
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
