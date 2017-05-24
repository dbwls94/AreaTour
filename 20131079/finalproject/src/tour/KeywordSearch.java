package tour;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KeywordSearch
 */
@WebServlet("/tour/keyword")
public class KeywordSearch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String area = (String)request.getAttribute("area");
		//String area = new String(request.getParameter("area").getBytes("8859_1"), "UTF-8");
		System.out.println("keyword : " + area);
	}


}
