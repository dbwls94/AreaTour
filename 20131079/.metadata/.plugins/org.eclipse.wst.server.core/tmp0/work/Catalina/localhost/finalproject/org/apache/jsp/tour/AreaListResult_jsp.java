/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2015-12-16 00:15:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.tour;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import tour.Map;
import java.util.*;

public final class AreaListResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>관광정보 안내 서비스</title>\r\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t\t<meta name=\"description\" content=\"\" />\r\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\" />\r\n");
      out.write("\t\t<!--[if lte IE 8]><script src=\"js/html5shiv.js\"></script><![endif]-->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction totalmethod($addr1, $title)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tsetAddr1_s($addr1);\r\n");
      out.write("\t\t\t\tsetTitle_s($title);\r\n");
      out.write("\t\t\t\talert(\"$addr1\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction setAddr1_s($addr1)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar b = document.querySelector(\"a\"); \r\n");
      out.write("\r\n");
      out.write("\t\t\t\tb.setAttribute(\"addr1_s\", $addr1);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction setTitle_s($title)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tvar b = document.querySelector(\"a\"); \r\n");
      out.write("\r\n");
      out.write("\t\t\t\tb.setAttribute(\"title_s\", $title);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/skel.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/skel-layers.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/init.js\"></script>\r\n");
      out.write("\t\t<noscript>\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/skel.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"css/style-xlarge.css\" />\r\n");
      out.write("\t\t</noscript>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"landing\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Header -->\r\n");
      out.write("\t\t\t<header id=\"header\" class=\"alt\">\r\n");
      out.write("\t\t\t\t<h1><strong><a href=\"index.html\">Duksung</a></strong> by youjin</h1>\r\n");
      out.write("\t\t\t\t<nav id=\"nav\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Generic</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Elements</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</header>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Banner -->\r\n");
      out.write("\t\t\t<section id=\"banner\">\r\n");
      out.write("\t\t\t\t<h2>Duksung</h2>\r\n");
      out.write("\t\t\t\t<p>20131079 컴퓨터학과 박유진</p>\r\n");
      out.write("\t\t\t\t<ul class=\"actions\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" class=\"button special big\">Get Started</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Two -->\r\n");
      out.write("\t\t\t\t<section id=\"two\" class=\"wrapper style2 special\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t");
 String slarea = (String)request.getAttribute("slarea"); 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<h1>찾으시는 [");
      out.print(slarea );
      out.write("] 지역의 관광명소 리스트입니다.</h1>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"viewmap\" method=\"GET\">\r\n");
      out.write("                                <table border=\"1\" style=\"width:100%\">\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>이름</td>\r\n");
      out.write("                                        <td>주소</td>\r\n");
      out.write("                                        <td>지도에서 확인</td>\r\n");
      out.write("                                        <td>대분류</td>\r\n");
      out.write("                                        <td>이미지</td>\r\n");
      out.write("                                        <td>전화번호</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("\r\n");
      out.write("                                    ");
 ArrayList<Map> lists = (ArrayList<Map>)request.getAttribute("list");
                                    	String cat1="";
                                            for(Map list : lists) 
                                            { 
                                            	if((list.getCat1()).equals("A01"))
                                            		cat1 = "자연";
                                            	else if((list.getCat1()).equals("A02"))
                                            		cat1 = "인문(문화/예술/역사)";
                                            	else if((list.getCat1()).equals("A03"))
                                            		cat1 = "레포츠";
                                            	else if((list.getCat1()).equals("A04"))
                                            		cat1 = "쇼핑";
                                            	else if((list.getCat1()).equals("A05"))
                                            		cat1 = "음식";
                                            	else if((list.getCat1()).equals("B02"))
                                            		cat1 = "숙박";
                                            	else if((list.getCat1()).equals("C01"))
                                            		cat1 = "추천코스";
                                            
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td>");
      out.print(list.getTitle());
      out.write("</td>\r\n");
      out.write("                                                <td>");
      out.print(list.getAddr1());
      out.write("</td>\r\n");
      out.write("                                                <td><input type=\"radio\" name=\"onmap\" value=\"");
      out.print(list.getAddr1());
      out.write(',');
      out.print(list.getTitle());
      out.write("\"></td>\r\n");
      out.write("                                                <td>");
      out.print( cat1 );
      out.write("</td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                \t<img src=\"");
      out.print(list.getFirstimage());
      out.write("\" align=\"center\" width=\"100px\" height=\"100px\">\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td>");
      out.print(list.getTel());
      out.write("</td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                            ");
} 
      out.write("\r\n");
      out.write("                                </table>\r\n");
      out.write("\r\n");
      out.write("                                <input type=\"submit\" value=\"지도에서 확인\">\r\n");
      out.write("                                <input type=\"reset\" value=\"초기화\">\r\n");
      out.write("                            </form>\r\n");
      out.write("                            \r\n");
      out.write("                            <form action=\"MainPage.jsp\" method=\"GET\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"홈으로\" style=\"background-color:red;\">\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Three -->\r\n");
      out.write("\t\t\t\t<!-- <section id=\"three\" class=\"wrapper style1\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"feature-grid\">\r\n");
      out.write("                        \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</section> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Four -->\r\n");
      out.write("\t\t\t\t<section id=\"four\" class=\"wrapper style3 special\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t<header class=\"major\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>웹정보시스템</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>과제</p>\r\n");
      out.write("\t\t\t\t\t\t</header>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"actions\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button special big\">Get in touch</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Footer -->\r\n");
      out.write("\t\t\t<footer id=\"footer\">\r\n");
      out.write("\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"icons\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-facebook\"></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-twitter\"></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-instagram\"></a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<ul class=\"copyright\">\r\n");
      out.write("\t\t\t\t\t\t<li>&copy; Untitled</li>\r\n");
      out.write("\t\t\t\t\t\t<li>Design: <a href=\"http://templated.co\">TEMPLATED</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li>Images: <a href=\"http://unsplash.com\">Unsplash</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}