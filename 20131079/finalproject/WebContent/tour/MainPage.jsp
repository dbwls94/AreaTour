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
			alert('어서오세요! 박유진님!');

			function notEmpty(){
				var myTextField = document.getElementById('myText');
				if(myTextField.value != "")
					alert("You entered: " + myTextField.value)
				else
					alert("Would you please enter some text?")		
			}
		</script>
		<script type="text/javascript" 
								src="//apis.daum.net/maps/maps3.js?apikey=d4a5fc60d12d06e0be6a9282fa0bd3aa"></script>
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
						<header class="major">
							<h2>원하시는 옵션을 선택하세요</h2>
						</header>
						
                            <form action="AreaSearch.jsp" method="GET">
                                <input type="submit" value="지역 검색">
                            </form>
                            
                            <form action="KeywordSearchResult.jsp" method="GET">
								<input type="submit" value="키워드로 검색">
							</form>
								
                            <form action="AreaList.jsp" method="GET">
                                <input type="submit" value="지역별 관광명소 리스트">
                            </form>
                            
					</div>
				</section>

			<!-- Three -->
				<section id="three" class="wrapper style1">
					<div class="container">
						<div class="feature-grid">
                            <div id="map" style="width:100%;height:400px;"></div>
								
								<script>
									var container = document.getElementById('map');
									var options = {
										center: new daum.maps.LatLng(33.450701, 126.570667),
										level: 3
									};
							
									var map = new daum.maps.Map(container, options);
								</script>
						</div>
					</div>
				</section>

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