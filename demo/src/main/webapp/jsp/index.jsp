<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>家庭记账本主页</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	$(function () {
		//验证非空，并提交查询请求
		$("#submit").click(function () {
			//验证输入框是否为空
			var keyword = $("#keyword").val();
			if(keyword ==""){
				alert("请输入关键字");
				return false;
			}else {
				//javascript语言提供了一个location地址栏对象
				//它有一个属性href,可以获取浏览器中地址栏地址
				location.href="../bs?action=query&keyword="+keyword;
			}

		});
		
	});
	</script>
</head>
<body>
	<div id="header">
		<span class="wel_word">家庭记账本</span>
		<div>
   			<a href="../bs?action=list">往期消费记录</a>
   			<a href="cost_edit.jsp">新增消费记录</a>
   			<input style="margin-left:20px"id="keyword" name="keyword" type="text" placeholder="请输入关键字"value=""/>
			<input id="submit"type="submit" value="查询"/>
		</div>
	</div>
	
	<div id="main">
		<h1>欢迎进入家庭记账本系统</h1>
	</div>
	
</html>