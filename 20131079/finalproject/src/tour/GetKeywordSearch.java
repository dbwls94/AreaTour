package tour;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class GetKeywordSearch
 */
@WebServlet("/tour/getkeyword")
public class GetKeywordSearch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ArrayList<Map> maps2;
	ArrayList<Map> titles2;
	String areacode2;
	String area2;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected static boolean isTextNode(Node n)
	{
		return n.getNodeName().equals("#text");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		
		//지역 받아오기
		//String area = new String(request.getParameter("area").getBytes("8859_1"), "UTF-8");
		//System.out.println(area);
		
		//areacode 지역 코드 받아오기
		areacode2 = (String)request.getAttribute("code2");
		area2 = (String)request.getAttribute("area2");
		String areaEncoding2 = URLEncoder.encode(area2, "UTF-8"); 
		
		getKeyword(areacode2, areaEncoding2); //이제 areacode로 구별
		
		// request에 지역검색결과 데이터 보관한다.
		request.setAttribute("maps", maps2); //위도/경도
		request.setAttribute("titles", titles2); //title 저장
		
		// JSP로 출력을 위임한다.
		RequestDispatcher rd = request.getRequestDispatcher("/tour/KeywordSearchResult.jsp");
		rd.include(request, response);
	}
	
	@SuppressWarnings("unused")
	public void getKeyword(String areacode2, String areaEncoding2) 
	{
		// 관광정보 URL주소
	    final String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey=";
	    // 관광정보 key
	    final String key = "cngfipRA4I2lN8TleA7CRLRxc1d6kI3HsgYeMMt4h3HS980hGmrGLtInsvvUSOnSJ5vVllpNMi3jzImhg8U7YA%3D%3D";
	    
	    // 페이지 관련 주소
	    //각 지역마다 500개씩 가져옴
	    final String url2 = "&numOfRows=500&pageSize=500&pageNo=1&startPage=1&arrange=A&listYN=Y&areaCode=";
	    final String url3 = "&MobileOS=ETC&MobileApp=AppTesting";
	    
	    int number = 0;
	    
	    //여기서 받은 위도/경도(x, y)값을 지도가 보여지는 TourMain.jsp페이지로 넘겨줌. 
	    //jsp페이지에서 그 x, y를 받아서 해당 위도/경도의 위치를 보여준다.
	    try
        {
	    	String codeEncoding = URLEncoder.encode(areacode2, "UTF-8");
            String strURL = url + key + "&keyword=" + areaEncoding2+ url2 + codeEncoding + url3;
            
            //System.out.println("1");
            // 위의 url로 request를 던지면 xml형식의 결과를 반환한다
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(strURL);
            
            Element root = doc.getDocumentElement(); //response가져옴
            Node body = root.getLastChild(); //response의 마지막 자식인 body를 가져옴
            Node items = body.getFirstChild(); //body의 첫번째 자식인 items 가져옴
            NodeList item = items.getChildNodes(); //items의 자식들을 가져옴

            System.out.println("item개수 : " + item.getLength());
            
            maps2 = new ArrayList<Map>(); //객체 형태로 위도/경도(x, y)를 저장
            titles2 = new ArrayList<Map>(); //객체 형태로 title 저장
            
            //Node rpageNo = item.item(12); //<pageNo>태그 가져오기
            //for(int y = 1; y<=number; y++)
            {
            	//if((rpageNo.getFirstChild().getNodeValue()).equals(y)) //<pageNo>의 값이 1일때부터~
            	{
            		for (int i = 0; i < item.getLength(); i++) 
                    {
                       Node ele = item.item(i); //첫번째 item부터 가져옴
                       if (isTextNode(ele))
                          continue;

                       //item의 자식들을 가져옴
                       NodeList eleList = ele.getChildNodes(); 
                       //System.out.println("3");
                       
                       for(int j = 0; j<eleList.getLength(); j++)
                       {
                    	   Node mapx = eleList.item(j);
                    	   //System.out.println("4");
                    	   if(mapx.getNodeName().equals("mapx"))
                    	   {
                               maps2.add(new Map().setX(mapx.getFirstChild().getNodeValue()));
                               System.out.print(j+"번째 x : " + mapx.getFirstChild().getNodeValue()+"  ");
                    	   }
                    	   
                    	   Node mapy = eleList.item(j);
                    	   //System.out.println("5");
                    	   if(mapy.getNodeName().equals("mapy"))
                    	   {
                               maps2.add(new Map().setY(mapy.getFirstChild().getNodeValue()));
                               System.out.print(j+"번째 y : " + mapy.getFirstChild().getNodeValue()+"  ");
                    	   }
                    	   
                    	   Node title = eleList.item(j);
                    	   if(title.getNodeName().equals("title"))
                    	   {
                    		   titles2.add(new Map().setTitle(title.getFirstChild().getNodeValue()));
                               System.out.print(j+"번째 title : " + title.getFirstChild().getNodeValue()+"  ");
                    	   }
                       }
                       
                    }
            	}
            }
            

            System.out.println("title 개수 : " + titles2.size());
            
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	}
}
