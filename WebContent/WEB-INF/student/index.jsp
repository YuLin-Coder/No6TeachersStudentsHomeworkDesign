<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生首页</title>
</head>
<body style="border: 1px solid black; width: 320px; height: 200px;">
	<div style="margin: 15px auto;">
		<div style="margin: 30px 60px 0px; color: red; font-weight: bold; font-size: 20px;">
			 欢迎你，${username }
   			<c:if test="${role=='2'}">
   			学生
   			</c:if>
		</div>
		<br/>
   		<a href="studentLookWork.jsp" style="margin-left: 115px;">查看作业</a>
   		<br/>
   		<br/>
   		<div style="margin-left: 80px;">当前在线人数：${online }</div>
	</div>
</body>
</html>