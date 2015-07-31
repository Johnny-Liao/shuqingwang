<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 书磬网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.4.3.js"></script>
		<script src="../js/checkUserLogin.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录书磬网
						</h3>

						<form method="post" action="checkUser" id="login_form">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="user.email" id="txtUsername" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="user.password" id="txtPassword"
										class="textbox" />
								</li>
								<li>

									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />


								</li>
							</ul>
							<div align="center" id="repeatPassValidMsg">
							    <p id="login.info" style="color:red"><s:property value="#request.login_error"/></p>
							</div>
							<div align="center" id="repeatPassValidMsg">
							    <p id="email.info" style="color:red"></p>
							</div>
							<div align="center" id="repeatPassValidMsg">
							    <p id="password.info" style="color:red"></p>
							</div>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是书磬网用户？
						</p>
						<p class="set_up">
							<a href="register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

