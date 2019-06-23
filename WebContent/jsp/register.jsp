<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome to register</title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="/Drugsmanagement/css/redisterstyle.css" />
		<script>
			$(function(){
				$("#username").focus(function(){
					$(".bgimg").find("#usernamespan").remove();
					$(".userinput").parent().append("<span id='usernamespan'><img class='smallimg' src='../img/tip.png' /><font>4~8位</font></span>");
				});
				$("#password").focus(function(){
					$(".bgimg").find("#passwordspan").remove();
					$(".userinput").parent().append("<span id='passwordspan'><img class='smallimg' src='../img/tip.png' /><font>6~16位（包含字母、数字、特殊符号）</font></span>");
				});
				$("#repassword").focus(function(){
					$(".bgimg").find("#repasswordspan").remove();
					$(".userinput").parent().append("<span id='repasswordspan'><img class='smallimg' src='../img/tip.png' /><font>两次密码需要一致哦~</font></span>");
				});
				
				$(".form-control").blur(function(){
					var value = this.value;
					if($(this).is("#password")){
						$(".bgimg").find("#passwordspan").remove();
						var patt = /^(?=.*\d)(?=.*[a-zA-Z])(?=.*[\W_]).{6,16}$/;
						if((value.length > 0 &&value.length <6)||value.length>16){
							$(".userinput").parent().append("<span id='passwordspan'><img class='smallimg onErr' src='../img/error.png' />长度不对哦~</span>");
						}else if(patt.test(value)){
							$(".userinput").parent().append("<span id='passwordspan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");	
						}else if(value.length == 0){
							
						}
						else{
							$(".userinput").parent().append("<span id='passwordspan'><img class='smallimg onErr' src='../img/error.png' />格式不正确哦~</span>");							
						}
					}
					else if($(this).is("#repassword")){
						var password = $("#password").val();
						$(".bgimg").find("#repasswordspan").remove();
						if(value != password){
							$(".userinput").parent().append("<span id='repasswordspan'><img class='smallimg onErr' src='../img/error.png' />两次密码不一致</span>");
						}else if(value.length == 0){
							
						}
						else{
							$(".userinput").parent().append("<span id='repasswordspan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");							
						}
					}
					else if($(this).is("#email")){
						$(".bgimg").find("#emailspan").remove();
						var patt = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
						if(patt.test(value)){
							$(".userinput").parent().append("<span id='emailspan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");														
						}else if(value.length == 0){
							
						}
						else{
							$(".userinput").parent().append("<span id='emailspan'><img class='smallimg onErr' src='../img/error.png' />格式不正确</span>");														
						}
					}
					else if($(this).is("#phone")){
						$(".bgimg").find("#telspan").remove();
						var patt = /^1[34578]\d{9}$/;
						if(patt.test(value)){
							$(".userinput").parent().append("<span id='telspan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");																					
						}else if(value.length == 0){
							
						}
						else{
							$(".userinput").parent().append("<span id='telspan'><img class='smallimg onErr' src='../img/error.png' />手机号码无效</span>");																					
						}
					}
					else if($(this).is("#name")){
						if(value.length >0){
							$(".userinput").parent().append("<span id='namespan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");																												
						}
					}
				}).keyup(function(){
					$(this).triggerHandler("blur");
				});
				
				
				$("#username").blur(function(){
					var value = this.value;
					$(".bgimg").find("#usernamespan").remove();
					if(value.length >= 4 && value.length <=8){
						/* ajax提交用户名，验证用户名是否可以使用 */
						$.post("/Drugsmanagement/checkUserNameServlet",{username : value},function(data,status){
							if(data == 0){
								$(".userinput").parent().append("<span id='usernamespan'><img class='smallimg onErr' src='../img/error.png' />用户名已经被注册了</span>");
							}else{
								$(".userinput").parent().append("<span id='usernamespan'><img class='smallimg onSuccess' src='../img/right.png' /></span>");
							}
						});

					}else if(value.length == 0){
						
					}
					else{
						$(".userinput").parent().append("<span id='usernamespan'><img class='smallimg onErr' src='../img/error.png' />长度不对哦~</span>");
					}
				});
				
				$("form").submit(function(){
					var errlen = $(".onErr").length;
					var succlen = $(".onSuccess").length;
					
					if(succlen >= 6 && errlen == 0){
						return true;
					}else{
						return false;
					}
				});
			});

		</script>
	</head>
	<body>
		<div class="bgimg">
			<div class="table1"></div>
			<form action="/Drugsmanagement/RegisterServlet" method="post">
				<div class="userinput">
					<div>
						<h2><font size="7">Welcome </font>to register</h2>
					</div>
					<span class="input-group input1" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">用户名：</span>
	  					<input type="text" class="form-control" placeholder="请输入用户名" aria-describedby="sizing-addon2" id="username" name="username">
					</span>
					<div class="input-group input2" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">密码：</span>
	  					<input type="password" class="form-control" placeholder="请输入密码" aria-describedby="sizing-addon2" id="password" name="password">
					</div>
					<div class="input-group input3" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">确认密码：</span>
	  					<input type="password" class="form-control" placeholder="请再次输入密码" aria-describedby="sizing-addon2" id="repassword" name="repassword">
					</div>
					<div class="input-group input4" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">邮箱：</span>
	  					<input type="email" class="form-control" placeholder="请输入邮箱" aria-describedby="sizing-addon2" id="email" name="email">
					</div>
					<div class="input-group input5" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">手机号：</span>
	  					<input type="tel" class="form-control" placeholder="请输入手机号" aria-describedby="sizing-addon2" id="phone" name="phone">
					</div>
					<div class="input-group input6" style="width: 300px;">
	  					<span class="input-group-addon uname" id="sizing-addon2">真实姓名：</span>
	  					<input type="text" class="form-control" placeholder="请输入姓名" aria-describedby="sizing-addon2" id="name" name="realname">
					</div>
					<div class="butt">
						<button type="submit" class="btn" style="background-color: white; color: darkslateblue;">立即注册</button>
					</div>
					<div>
						<a href="/Drugsmanagement/html/login_in.html"><img src="../img/break.png" class="bre"></a>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
