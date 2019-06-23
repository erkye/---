<%@page import="com.li.util.CookiesUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<title>JSP Page</title>
	</head>

	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
					<p class="navbar-text">
						<font size="3"><b>药品存销信息管理系统</b></font>
					</p>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							<a href="/Drugsmanagement/DrugsListServlet">药品信息 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="/Drugsmanagement/StaffListSevlet">员工管理</a>
						</li>
						<li>
							<a href="/Drugsmanagement/CustomerListServlet">客户管理</a>
						</li>
						<li>
							<a href="/Drugsmanagement/OutHouseListServlet">出库记录</a>
						</li>
						<li>
							<a href="/Drugsmanagement/InHouseListServlet">入库记录</a>
						</li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li>
							<span class="glyphicon glyphicon-user" aria-hidden="true" style="top: 18px;color: #dedede;">&nbsp;<font color="#dedede">欢迎您，	<%
							String username = null;
							Cookie[] cookies = request.getCookies(); 
							Cookie cookie = CookiesUtil.findCookie(cookies, "username");
							username = cookie.getValue();
							%>
							<%=username %></font></span>
						</li>
						&nbsp;&nbsp;

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号管理 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li class="active">
									<a href="/Drugsmanagement/SeeUserDataServlet">个人资料</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="/Drugsmanagement/html/login_in.html">注销登录</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<center>
			<div class="panel panel-default" style="width: 45%;">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<font size="4"><b>个人资料</b></font>
				</div>

				<!-- Table -->
				<table class="table table-striped table-hover">
					<tr align="center">
						<td>用户名</td>
						<td>${userData.username }</td>
					</tr>
					<tr align="center">
						<td>邮箱</td>
						<td>${userData.email }</td>
					</tr>
					<tr align="center" >
						<td>手机号</td>
						<td>${userData.phone }</td>
					</tr>
					<tr align="center">
						<td>真实姓名</td>
						<td>${userData.realname }</td>
					</tr>
				</table>
			</div>
		</center>
	</body>
</html>