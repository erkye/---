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
		<script type="text/javascript">
		$(function(){
			$("#insertbutton").click(function(){
				window.location.href="/Drugsmanagement/InsertOutHouseDisplayServlet";
			});
			if($("#resulthidden").val() != ""){
				alert($("#resulthidden").val());
			};
			//jsp中不能使用click事件，click事件不能处理动态添加
			$(".deleteDrug").on('click', function(){
				var oid = $(this).val();
				//弹出提示框，提示用户是否确认删除
				var flag = confirm("是否确认删除？");

				if(flag){
					//js里面的页面跳转
					window.location.href = "/Drugsmanagement/DeleteOutHouseServlet?oid="+oid;
				}
				
			});
			$(".reDrug").on('click',function(){
				
				var oid = $(this).val();
				window.location.href = "/Drugsmanagement/RelOutHouseDisplayServlet?oid=" + oid;
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
						<li class="active">
							<a href="/Drugsmanagement/OutHouseListServlet">出库记录</a>
						</li>
						<li>
							<a href="/Drugsmanagement/InHouseListServlet">入库记录</a>
						</li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li>
							<span class="glyphicon glyphicon-user" aria-hidden="true" style="top: 18px;color: #dedede;">&nbsp;<font color="#dedede">欢迎您，
							<%
							String username = null;
							Cookie[] cookies = request.getCookies(); 
							Cookie cookie = CookiesUtil.findCookie(cookies, "username");
							if(cookie != null){
								username = cookie.getValue();
							}else{
								username = "请刷新";
							}
							%>
							<%=username %> </font></span>
						</li>
						&nbsp;&nbsp;

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号管理 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
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
			<div class="panel panel-default" style="width: 70%;">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<font size="4"><b>出库记录</b></font>
					<form class="navbar-form" action="OutHouseFuzzyQueryServlet" method="post">
						<div class="form-group">
							药品名：<input type="text" class="form-control" placeholder="请输入药品名称" name="drugname">
						</div>
						&nbsp;
						&nbsp;
						&nbsp;
						<div class="form-group">
							顾客：<input type="text" class="form-control" placeholder="请输入顾客姓名" name="customername">
						</div>
						&nbsp;
						&nbsp;
						&nbsp;
						<div class="form-group">
							经手人：<input type="text" class="form-control" placeholder="请输入经手人" name="staffname">
						</div>
						&nbsp;
						&nbsp;
						&nbsp;
						<button type="submit" class="btn btn-primary">查找</button>
					</form>
					
					<button type="button" class="btn btn-primary" id="insertbutton">添加新的出库记录</button>
				</div>

				<!-- Table -->
				<table class="table table-striped table-hover">
					<tr align="center" class="active">
						<td>#</td>
						<td>出库编号</td>
						<td>药品名称</td>
						<td>出库时间</td>
						<td>出库数量</td>
						<td>顾客</td>
						<td>经手人</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${outhouselist }" var="outhouse">
					<tr align="center">
						<td></td>
						<td>${outhouse.oid }</td>
						<td>${outhouse.dname }</td>
						<td>${outhouse.odate }</td>
						<td>${outhouse.onum }</td>
						<td>${outhouse.cname }</td>
						<td>${outhouse.sname }</td>
						<td>
						<button type="button" class="btn btn-danger deleteDrug" value="${outhouse.oid }">删除</button>&nbsp;&nbsp;
						<button type="button" class="btn btn-primary reDrug" value="${outhouse.oid }">修改</button></td>
					</tr>	
					</c:forEach>
				</table>
			</div>
		</center>
	</body>
</html>