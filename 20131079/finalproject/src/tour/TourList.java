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
 * Servlet implementation class TourList
 */
@WebServlet("/tour/tourlist")
public class TourList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String code;
	ArrayList<Map> list;
	String[] info;
	String slareaEncoding;
	
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
		request.setCharacterEncoding("UTF-8");
		
		//내가 체크한 지역의 value값(이름)을 받아옴
		String slarea = new String(request.getParameter("search").getBytes("8859_1"), "UTF-8");
		
		
		
		getCode(slarea); //해당 지역의 지역코드 얻기
		System.out.println("선택 지역 이름 : " + slarea + " code : " + code);
		
		getTourList(slarea, code); //해당 지역의 관광명소 정보들을 얻어옴
		
		// request에 지역검색결과 데이터 보관한다.
		request.setAttribute("list", list); //정보
		request.setAttribute("slarea", slarea); //선택한 지역 이름
		request.setAttribute("slareaEncoding", slareaEncoding);
		//System.out.println(slareaEncoding);
		// JSP로 출력을 위임한다.
		RequestDispatcher rd = request.getRequestDispatcher("/tour/AreaListResult.jsp");
		rd.include(request, response);
	}
	
	public void getTourList(String slarea, String code) 
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
	    	slareaEncoding = URLEncoder.encode(slarea, "UTF-8");
	    	String codeEncoding = URLEncoder.encode(code, "UTF-8");
            String strURL = url + key + "&keyword=" + slareaEncoding+ url2 + codeEncoding + url3;
            
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
            
            list = new ArrayList<Map>(); //해당 지역의 관광지 정보 저장
            
            
            		for (int i = 0; i < item.getLength(); i++) 
                    {
            			info = new String[5]; //이름(title), 주소(addr1), 대분류(cat1), 이미지(firstimage), 전화번호(tel)
            			
                       Node ele = item.item(i); //첫번째 item부터 가져옴
                       if (isTextNode(ele))
                          continue;

                       //item의 자식들을 가져옴
                       NodeList eleList = ele.getChildNodes(); 
                       //System.out.println("3");
                       
                       for(int j = 0; j<eleList.getLength(); j++)
                       {
                    	   Node title = eleList.item(j); //title 태그
                    	   //System.out.println("4");
                    	   if(title.getNodeName().equals("title"))
                    	   {
                    		   info[0] = title.getFirstChild().getNodeValue();
                               //list.add(new Map().setTitle(info[0]));
                               System.out.print("title : " + info[0]+"  ");
                    	   }
                    	   
                    	   Node addr1 = eleList.item(j); //addr1 태그
                    	   //System.out.println("5");
                    	   if(addr1.getNodeName().equals("addr1"))
                    	   {
                    		   info[1] = addr1.getFirstChild().getNodeValue();
                               //list.add(new Map().setAddr1(info[1]));
                               System.out.print("addr1 : " + info[1]+"  ");
                    	   }
                    	   /*else
                    	   {
                    		   info[1] = "X";
                    		   System.out.print("addr1 : " + info[1]+"  ");
                    	   }*/
                    	   
                    	   Node cat1 = eleList.item(j); //cat1 태그
                    	   if(cat1.getNodeName().equals("cat1"))
                    	   {
                    		   info[2] = cat1.getFirstChild().getNodeValue();
                               //list.add(new Map().setCat1(info[2]));
                               System.out.print("cat1 : " + info[2]+"  ");
                    	   }
                    	   /*else
                    	   {
                    		   info[2] = "X";
                    		   System.out.print("cat1 : " + info[2]+"  ");
                    	   }*/
                    	   
                    	   Node firstimage = eleList.item(j); //firstimage 태그
                    	   if(firstimage.getNodeName().equals("firstimage"))
                    	   {
                    		   info[3] = firstimage.getFirstChild().getNodeValue();
                               //list.add(new Map().setCat1(info[2]));
                               System.out.print("firstimage : " + info[3]+"  ");
                    	   }
                    	   /*else
                    	   {
                    		   info[3] = "X";
                    		   System.out.print("firstimage : " + info[3]+"  ");
                    	   }*/
                    	   
                    	   Node tel = eleList.item(j); //tel 태그
                    	   if(tel.getNodeName().equals("tel"))
                    	   {
                    		   info[4] = tel.getFirstChild().getNodeValue();
                               //list.add(new Map().setCat1(info[2]));
                               System.out.print("tel : " + info[4]+"  ");
                    	   }
                    	   /*else
                    	   {
                    		   info[4] = "X";
                    		   System.out.print("tel : " + info[4]+"  ");
                    	   }*/
                       }
                       
                       //arraylist에 저장
                       list.add(new Map()
						.setTitle(info[0])
						.setAddr1(info[1])
						.setCat1(info[2])
						.setFirstimage(info[3])
						.setTel(info[4]));
                       
                    }
  

            //System.out.println("title 개수 : " + titles.size());
            
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
	
	public void getCode(String slarea) 
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
	    	//String keywordEncoding = URLEncoder.encode(slarea, "UTF-8"); //area
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
                	if(c_name.equals(slarea))
                	{
                		code = eleList.item(0).getFirstChild().getNodeValue();
                		//System.out.println("3");
                		break;
                	}
                		
         	    }
            }
            //System.out.println("지역 : " + slarea + " code : " + code);
            //System.out.println("지역 개수 : " + item.getLength()); //17
            
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
