<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是员工信息修改页面</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
   function update() {
	var user = $("#account").val();
	var name = $("#name").val();
	var password = $("#password").val();
	var nickName = $("#nickName").val();
	$.ajax({
		type:"POST",//Ajax请求的提交方式（GET或POST）
		dataType:"text",//请求的类型
		url:"UpdateServlet",//发送的目标地址
		async:true,
		data:{
			user : user,
			name : name,
			password : password,
			nickName : nickName
		},//发送的参数。JSON的格式
		success:function(data){
			//请求成功后会执行这个函数里面的代码，参数data存放着服务器发回来的响应
			alert(data)
			if (data =="ok") {
				alert("修改成功")
				location.href="USer.jsp"
			}else {
				alert("用户名密码错误")
			}
		},	
		error:function(exception){
			//请求失败后会执行这个函数里面的代码，参数exception存放着错误信息
		}
	});
}
	
	</script>

</head>
<body>
<form action="updateServlet" method="post">
<table align="center" border="1" width="500px">

<tr>
<td>用户编号</td>
<td><input type="text" id="account" name="account" value="<%= request.getParameter("account")%>"></td>
</tr>
<tr>
<td>用户名称</td>
<td><input type="text" id="name" name="name" value="<%= request.getParameter("name")%>"></td>
</tr>

<tr>
<td>用户密码</td>
<td><input type="text" id="password" name="password" value="<%= request.getParameter("password")%>"></td>
</tr>

<tr>
<td>用户昵称</td>
<td><input type="text" id="nickName" name="nickName" value="<%= request.getParameter("nickName")%>"></td>
</tr>

<tr>

<td colspan="2"><input type="submit" value="修改" onclick="update()"></td>
</tr>
</table>

</form>

</body>
</html>