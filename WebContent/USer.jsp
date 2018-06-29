<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    #userTbl th{border-right:solid 1px #000000;border-bottom:solid 1px #000000;}
    #userTbl td{border-right:solid 1px #000000;border-bottom:solid 1px #000000;}
    button {
	text-align: center;
	margin: 0px auto;
	margin-left: 750px;
	margin-top: 30px;
	width: 100px;
	height: 60px;
}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

</head>
<body>

	<table id="userTbl" cellspacing="0px" cellpadding="5px"
 style="width: 80%;margin: 0px auto;border-left:solid 1px #000000;border-top:  solid 1px #000000;text-align: center;">
		<tr>
			<th>用户编号</th>
			<th>用户名称</th>
			<th>用户密码</th>
			<th>用户昵称</th>
			<th>修改数据</th>
		</tr>
		
	</table>
	<button type="button">添加数据</button>
	<script type="text/javascript">
	$.ajax({
		type:"POST",//Ajax请求的提交方式（GET或POST）
		dataType:"text",//请求的类型
		url:"UserServlets",//发送的目标地址
		async:true,
		data:{operFlag:"getAllUSer"},//发送的参数。JSON的格式
		success:function(data){
			alert(data)
			var result = JSON.parse(data)
			
			var userInfoStr="";
			for(var i=0;i<result.length;i++){
				var user =result[i];
				userInfoStr = userInfoStr+"<tr class='userRow'  style='text-align:center;'>";
				userInfoStr = userInfoStr+"<td style='text-align:center;'>"+user.id+"</td>";
				userInfoStr = userInfoStr+"<td style='text-align:center;'>"+user.name+"</td>";
				userInfoStr = userInfoStr+"<td style='text-align:center;'>"+user.password+"</td>";
				userInfoStr = userInfoStr+"<td style='text-align:center;'>"+user.nickName+"</td>";
				userInfoStr = userInfoStr+"<td style='text-align:center;'>"+"<a href='chang.jsp?account="+user.id+"&name="+user.name+"&password="+user.password+"&nickName="+user.nickName+"'>修改</a>"+"</td>"
				userInfoStr = userInfoStr+"</tr>";
				$(".userRow").remove();
				$("#userTbl").append(userInfoStr);
			}
			//请求成功后会执行这个函数里面的代码，参数data存放着服务器发回来的响应
		},	
		error:function(exception){
			//请求失败后会执行这个函数里面的代码，参数exception存放着错误信息
		}
	});
	
	</script>
</body>
</html>