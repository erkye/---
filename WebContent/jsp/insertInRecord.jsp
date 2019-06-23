<%@page import="com.li.domain.DrugsBean"%>
<%@page import="java.util.List"%>
<%@page import="com.li.util.CookiesUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<title>JSP Page</title>
<script type="text/javascript">
	$(function() {
		//记录最大库存量
		var maxnums = 9999999;
		
		if($("#resulthidden").val() != ""){
			alert($("#resulthidden").val());
		};

		$("form").submit(function(){
			if($("#drugid").val().length == 0){
				alert("请选择药品名称！");
				return false;
			}
			if($("#nums").val().length == 0){
				alert("数量不能为空！");
				return false;
			}
			if($("#nums").val().length != 0){
				var nums = $("#nums").val();
				if(parseInt(nums) > parseInt(maxnums)){
					alert("输入的数量超出了仓库最大的库存量，请重新输入！");
					return false;
				}
				
			}
			if($("#outtime").val().length == 0){
				alert("请选择入库时间！");
				return false;
			}
			if($("#staffid").val().length == 0){
				alert("请选择经手人！");
				return false;
			}
			return true;
		});
	});
</script>
</head>

<body>
<input type="hidden" value="${insertresult }" id="resulthidden">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<p class="navbar-text">
				<font size="3"><b>药品存销信息管理系统</b></font>
			</p>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/Drugsmanagement/DrugsListServlet">药品信息 <span
						class="sr-only">(current)</span></a></li>
				<li><a href="/Drugsmanagement/StaffListSevlet">员工管理</a></li>
				<li><a href="/Drugsmanagement/CustomerListServlet">客户管理</a></li>
				<li><a href="/Drugsmanagement/OutHouseListServlet">出库记录</a></li>
				<li><a href="/Drugsmanagement/InHouseListServlet">入库记录</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><span class="glyphicon glyphicon-user" aria-hidden="true"
					style="top: 18px; color: #dedede;">&nbsp;<font
						color="#dedede">欢迎您， <%
					String username = null;
					Cookie[] cookies = request.getCookies();
					Cookie cookie = CookiesUtil.findCookie(cookies, "username");
					username = cookie.getValue();
				%> <%=username%></font></span></li> &nbsp;&nbsp;

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">账号管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/Drugsmanagement/SeeUserDataServlet">个人资料</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/Drugsmanagement/html/login_in.html">注销登录</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<center>
		<div class="panel panel-default" style="width: 45%;">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<font size="4"><b>添加入库记录</b></font>
			</div>

			<form action="/Drugsmanagement/InsertInHouseServlet" method="post">
				<!-- Table -->
				<table class="table table-striped table-hover">
					<tr align="center">
						<td>药品名称</td>
						<td>
						<select class="form-control" name="idid" id="drugid">
							<option value="">--请选择--</option>
							<c:forEach items="${druglist }" var="drug">
								<option value="${drug.did }">${drug.dname }&nbsp;&nbsp;&nbsp;(库存量:${drug.dnums })</option>
							</c:forEach>
						</select>
						
						</td>
					</tr>
					<tr align="center">
						<td>入库数量</td>
						<td><input type="text" class="form-control"
							placeholder="请输入数量" name="inum" id="nums">
							</td>
					</tr>
					<tr align="center">
						<td>入库时间</td>
						<td><input type="date" class="form-control" name="idate" id="outtime">
						</td>
					</tr>
					<tr align="center">
						<td>经手人</td>
						<td>
						<select class="form-control" name="ihandler" id="staffid">
							<option value="">--请选择--</option>
							<c:forEach items="${stafflist }" var="staff">
								<option value="${staff.sid }">${staff.sname }</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<button type="submit" class="btn btn-primary">添加</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>