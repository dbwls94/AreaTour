<%@page import="book.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Spatial by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>온라인 서점 예제</title>
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
						<header class="major">
							<h2>제목을 입력하세요 : </h2>
						</header>
						<div class="row 150%">
                            <form action='search' method='GET'>
                                                                      책 제목 : <input type="text" name="title"><br>
                                <input type="submit" value="검색">
                            </form>
						</div>
					</div>
				</section>

			<!-- Three -->
				<section id="three" class="wrapper style1">
					<div class="container">
						<div class="feature-grid">
                            <form action="order" method="GET" name="orderform">
                                <table border="1" style="width:100%">
                                    <tr>
                                        <td>저자</td>
                                        <td>제목</td>
                                        <td>가격</td>
                                        <td>남은 수량</td>
                                    </tr>

                                    <% ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
                                            for(Book book : books) { %>
                                            <tr>
                                                <td><%=book.getAuthor()%></td>
                                                <td><%=book.getTitle()%></td>
                                                <td><%=book.getPrice()%>원</td>
                                                <td><%=book.getQuantity()%>권</td>
                                            </tr>
                                            <%} %>
                                </table>
                            </form>
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