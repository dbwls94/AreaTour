<%@page import="java.util.ArrayList"%>
<%@page import="tour.Map"%>
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
					
					<% String area = (String)request.getAttribute("area"); 
					//request.setAttribute("area", area);%>
					<h1>찾으시는 [<%=area %>] 지역의 관광명소들입니다.</h1>
					
						<div id="map" style="width:100%;height:500px;"></div>
							<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=d4a5fc60d12d06e0be6a9282fa0bd3aa"></script>
							
                                <% ArrayList<Map> maps = (ArrayList<Map>)request.getAttribute("maps");
                                ArrayList<Map> titles = (ArrayList<Map>)request.getAttribute("titles"); 
                                int j = 0;%> 
                                           
								<script>
									var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
									    mapOption = { 
									        center: new daum.maps.LatLng(<%=maps.get(1).getY() %>, <%=maps.get(0).getX() %>), // 지도의 중심좌표
									        level: 3 // 지도의 확대 레벨
									    };
									
									var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
									//var markerPosition;
									<% for(int i = 0; i<maps.size(); i++) { %>
										
										var markerPosition = new daum.maps.LatLng(<%=maps.get(i+1).getY() %>, <%=maps.get(i).getX() %>);
										 
										// 마커를 생성합니다
										var marker = new daum.maps.Marker({
											map: map, // 마커를 표시할 지도
										    position: markerPosition,
										    title : '<%=titles.get(j).getTitle() %>' 
										    // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
										    //clickable:true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하도록 설정합니다
										});
										
										// 마커가 지도 위에 표시되도록 설정합니다
										marker.setMap(map);
										
										<% System.out.println(i+"번째 : " + maps.get(i+1).getY() + "," + maps.get(i+1).getY() + " ");
										System.out.println(titles.get(j).getTitle());  %>	
									<% i++; 
									j++; %>
									<%} %>
									// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
									// marker.setMap(null);    
								</script>
								<br>
								
						</div>
						<br>
						
                            
                        
                        <br>
						<form action="MainPage.jsp" method="GET">
							<input type="submit" value="홈으로" style="background-color:red;"><br>
						</form> 
				</section>

			<!-- Three -->
				<!-- <section id="three" class="wrapper style1">
					<div class="container">
						  
						
					</div>
				</section> -->

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