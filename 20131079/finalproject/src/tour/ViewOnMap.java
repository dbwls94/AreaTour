package tour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewOnMap
 */
@WebServlet("/tour/viewmap")
public class ViewOnMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String parame = new String(request.getParameter("onmap").getBytes("8859_1"), "UTF-8");
		//? 기준으로 자르기
		String[] values = parame.split(",");
		for( int x = 0; x < values.length; x++ )
		{

		    System.out.println( "문자(열) " + (x+1) + " : " + values[x] );

		}
		//System.out.println(parame);
		request.setAttribute("addr1_p", values[0]);
		request.setAttribute("title_p", values[1]);
		
		// JSP로 출력을 위임한다.
		RequestDispatcher rd = request.getRequestDispatcher("/tour/AreaListResult2.jsp");
		rd.include(request, response);
	}
}
