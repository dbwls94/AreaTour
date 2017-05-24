<%@page import="tour.Map"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>관광정보 안내 서비스</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script type="text/javascript">
			function totalmethod($addr1, $title)
			{
				setAddr1_s($addr1);
				setTitle_s($title);
				alert("$addr1");
			}
			function setAddr1_s($addr1)
			{
				var b = document.querySelector("a"); 

				b.setAttribute("addr1_s", $addr1);
			}
			function setTitle_s($title)
			{
				var b = document.querySelector("a"); 

				b.setAttribute("title_s", $title);
			}
		</script>
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-xlarge.css" />
		</noscript>
	</head>
	<body class="landing">

		<!-- Header -->
			<header id="header" class="alt">
				<h1><strong><a href="index.html">Duksung</a></strong> by youjin</h1>
				<nav id="nav">
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">Generic</a></li>
						<li><a href="#">Elements</a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->
			<section id="banner">
				<h2>Duksung</h2>
				<p>20131079 컴퓨터학과 박유진</p>
				<ul class="actions">
					<li><a href="#" class="button special big">Get Started</a></li>
				</ul>
			</section>

			<!-- Two -->
				<section id="two" class="wrapper style2 special">
					<div class="container">
					<% String addr1_p = (String)request.getAttribute("addr1_p");
						String title_p = (String)request.getAttribute("title_p"); %>
						
						<h1>찾으시는 [<%=title_p %>]의 위치입니다.</h1>
						
						<div id="map" style="width:100%;height:350px;"></div>
							<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=d4a5fc60d12d06e0be6a9282fa0bd3aa&libraries=services"></script>
							
							<script>
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							    mapOption = {
							        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							        level: 3 // 지도의 확대 레벨
							    };  
							
							// 지도를 생성합니다    
							var map = new daum.maps.Map(mapContainer, mapOption); 
							
							// 주소-좌표 변환 객체를 생성합니다
							var geocoder = new daum.maps.services.Geocoder();
							
							// 주소로 좌표를 검색합니다
							geocoder.addr2coord('<%= addr1_p %>', function(status, result) {
							
							    // 정상적으로 검색이 완료됐으면 
							     if (status === daum.maps.services.Status.OK) {
							
							        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
							
							        // 결과값으로 받은 위치를 마커로 표시합니다
							        var marker = new daum.maps.Marker({
							            map: map,
							            position: coords
							        });
							
							        // 인포윈도우로 장소에 대한 설명을 표시합니다
							        var infowindow = new daum.maps.InfoWindow({
							            content: '<div style="padding:5px;"><%= title_p %></div>'
							        });
							        infowindow.open(map, marker);
							    } 
							});    
							</script>
					</div>
					<br>
					<form action="MainPage.jsp" method="GET">
						<input type="submit" value="홈으로"  style="background-color:red;">
					</form>
				</section>

			<!-- Three -->
				<%-- <section id="three" class="wrapper style1">
					<div class="container">
						<div class="feature-grid">
                        	<% String slarea = (String)request.getAttribute("slarea"); %>
						<h1>찾으시는 [<%=slarea %>] 지역의 관광명소 리스트입니다.</h1>
						<form action="viewmap" method="GET">
                                <table border="1" style="width:100%">
                                    <tr>
                                        <td>이름</td>
                                        <td>주소</td>
                                        <td>지도에서 확인</td>
                                        <td>대분류</td>
                                        <td>이미지</td>
                                        <td>전화번호</td>
                                    </tr>

                                    <% ArrayList<Map> lists = (ArrayList<Map>)request.getAttribute("list");
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
                                            %>
                                            
                                            <tr>
                                                <td><%=list.getTitle()%></td>
                                                <td><%=list.getAddr1()%></td>
                                                <td><input type="radio" name="onmap" value="<%=list.getAddr1()%>,<%=list.getTitle()%>"></td>
                                                <td><%= cat1 %></td>
                                                <td>
                                                	<img src="<%=list.getFirstimage()%>" align="center" width="100px" height="100px">
                                                </td>
                                                <td><%=list.getTel()%></td>
                                            </tr>
                                            <%} %>
                                </table>

                                <input type="submit" value="지도에서 확인">
                                <input type="reset" value="초기화">
                            </form>
                            
                            <form action="MainPage.jsp" method="GET">
								<input type="submit" value="홈으로">
							</form>
						</div>
					</div>
				</section> --%>

			<!-- Four -->
				<section id="four" class="wrapper style3 special">
					<div class="container">
						<header class="major">
							<h2>웹정보시스템</h2>
							<p>과제</p>
						</header>
						<ul class="actions">
							<li><a href="#" class="button special big">Get in touch</a></li>
						</ul>
					</div>
				</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<ul class="icons">
						<li><a href="#" class="icon fa-facebook"></a></li>
						<li><a href="#" class="icon fa-twitter"></a></li>
						<li><a href="#" class="icon fa-instagram"></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Untitled</li>
						<li>Design: <a href="http://templated.co">TEMPLATED</a></li>
						<li>Images: <a href="http://unsplash.com">Unsplash</a></li>
					</ul>
				</div>
			</footer>

	</body>
</html>