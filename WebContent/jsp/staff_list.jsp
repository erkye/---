<%@page import="com.li.util.CookiesUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$(function() {
		$("#insertbutton").click(function() {
			window.location.href = "/Drugsmanagement/jsp/insertStaff.jsp";
		});

		if($("#resulthidden").val() != ""){
			alert($("#resulthidden").val());
		};
		//jsp中不能使用click事件，click事件不能处理动态添加
		$(".deleteDrug").on('click',function() {
			var sid = $(this).val();
			//弹出提示框，提示用户是否确认删除
			var flag = confirm("是否确认删除？");

			if (flag) {
			//js里面的页面跳转
			window.location.href = "/Drugsmanagement/DeleteStaffServlet?sid="+ sid;
			}

		});
		$(".reDrug").on('click',function() {

			var sid = $(this).val();
			window.location.href = "/Drugsmanagement/StaffDisplayServlet?sid="+ sid;
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
				<li class="active"><a href="/Drugsmanagement/StaffListSevlet">员工管理</a>
				</li>
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
				%> <%=username%>
					</font>
					</span>
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
	<!-- /.container-fluid --> </nav>
	<center>
		<div class="panel panel-default" style="width: 60%;">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<font size="4"><b>员工信息表</b></font>
				<form class="navbar-form" action="StaffFuzzyQueryServlet"
					method="post">
					<div class="form-group">
						员工姓名：<input type="text" class="form-control" placeholder="请输入员工姓名"
							name="staffname">
					</div>
					&nbsp; &nbsp; &nbsp;
					<div class="form-group">
						性别： 
						<select class="form-control" name="staffsex">
							<option value="">--请选择--</option>
							<option value="男">男</option>
							<option value="女">女</option>
							<option value="保密">保密</option>
						</select>
					</div>
					&nbsp; &nbsp; &nbsp;
					<div class="form-group">
						职务：
						<select class="form-control" name="staffjop">
							<option value="">--请选择--</option>
							<option value="仓库管理员">仓库管理员</option>
							<option value="保洁员">保洁员</option>
							<option value="记录员">记录员</option>
							<option value="搬运员">搬运员</option>
							<option value="运输员">运输员</option>
							<option value="经理">经理</option>
							<option value="董事长">董事长</option>
							<option value="其它">其它</option>
						</select>
					</div>
					&nbsp; &nbsp; &nbsp;
					<button type="submit" class="btn btn-primary">查找</button>
				</form>

				<button type="button" class="btn btn-primary" id="insertbutton">添加新的员工信息</button>
			</div>

			<!-- Table -->
			<table class="table table-striped table-hover">
				<tr align="center" class="active">
					<td>#</td>
					<td>员工编号</td>
					<td>员工姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>学历</td>
					<td>职务</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${stafflist }" var="staff">
					<tr align="center">
						<td></td>
						<td>${staff.sid }</td>
						<td>${staff.sname }</td>
						<td>${staff.ssex }</td>
						<td>${staff.sage }</td>
						<td>${staff.seducation }</td>
						<td>${staff.sjob }</td>
						<td>
							<button type="button" class="btn btn-danger deleteDrug"
								value="${staff.sid }">删除</button>&nbsp;&nbsp;
							<button type="button" class="btn btn-primary reDrug"
								value="${staff.sid }">修改</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</center>
</body>
</html>