package tour;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

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
 * Servlet implementation class GetAreacode
 */
@WebServlet("/tour/tourcode")
public class GetAreacode extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	String code;
	
	protected static boolean isTextNode(Node n)
	{
		return n.getNodeName().equals("#text");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		//입력한 지역 받아오기
		String area = new String(request.getParameter("area").getBytes("8859_1"), "UTF-8");
		
		
		//입력한 지역과 비교해서 지역코드 받아오기
		getCode(area);
		
		// request에 code 데이터 보관한다.
		request.setAttribute("code", code); 
		request.setAttribute("area", area);
		
		//tourapi 페이지로 넘김
		request.getRequestDispatcher("/tour/tourapi").forward(request, response);
	}

	public void getCode(String area) 
	{
		// 관광정보 URL주소
	    final String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=";
	    // 관광정보 key
	    final String key = "cngfipRA4I2lN8TleA7CRLRxc1d6kI3HsgYeMMt4h3HS980hGmrGLtInsvvUSOnSJ5vVllpNMi3jzImhg8U7YA%3D%3D";
	    // 관광정보의 Parameter(어디 지역인지)
	    final String url2 = "&numOfRows=17&pageSize=17&pageNo=1&startPage=1&MobileOS=ETC&MobileApp=%EA%B3%B5%EC%9C%A0%EC%9E%90%EC%9B%90%ED%8F%AC%ED%84%B8";
	    
	    //int number = 0;
	    
	    //여기서 받은 위도/경도(x, y)값을 지도가 보여지는 TourMain.jsp페이지로 넘겨줌. 
	    //jsp페이지에서 그 x, y를 받아서 해당 위도/경도의 위치를 보여준다.
	    try
        {
	    	//String keywordEncoding = URLEncoder.encode(area, "UTF-8"); //area
            String strURL = url + key + url2;
            
            //System.out.println("1");
            // 위의 url로 request를 던지면 xml형식의 결과를 반환한다
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(strURL);
            
            Element root = doc.getDocumentElement(); //response가져옴
            Node body = root.getLastChild(); //response의 마지막 자식인 body를 가져옴
            Node items = body.getFirstChild(); //body의 첫번째 자식인 items 가져옴
            NodeList item = items.getChildNodes(); //items의 자식들(item들)을 가져옴

            String c_name;
            
            for(int i = 0; i<item.getLength(); i++) //17개만큼 돌림
            {
            	Node ele = item.item(i); //각각의 item 순서대로 가져오기
            	if(isTextNode(ele))
            		continue;
            	
            	//item의 자식들을 가져옴
                NodeList eleList = ele.getChildNodes(); 
                Node name = eleList.item(1); //<name> 태그 가져옴
                
            	c_name = name.getFirstChild().getNodeValue(); //<name> 태그의 내용물 가져옴
            	//System.out.println("1 : "+c_name);
            	
            	
                //if(name.getNodeName().equals("name")) //<name> 태그와 같으면
         	    {
                	//System.out.println("2");
                	//<name>태그의 내용과 area가 같다면
                	if(c_name.equals(area))
                	{
                		code = eleList.item(0).getFirstChild().getNodeValue();
                		//System.out.println("3");
                		break;
                	}
                		
         	    }
            }
            System.out.println("지역 : " + area + " code : " + code);
            System.out.println("지역 개수 : " + item.getLength()); //17
            
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
		
	    
	    //return maps;
	}
}
