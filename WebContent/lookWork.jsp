<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师查看作业列表界面</title>
</head>
<body>
	<!--JDBC 驱动名及数据库 URL 数据库的用户名与密码，需要根据自己的设置useUnicode=true&characterEncoding=utf-8 防止中文乱码-->
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    	 url="jdbc:mysql://localhost:3306/no6_userdb?useUnicode=true&characterEncoding=utf-8"
    	 user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
	SELECT * from t_works;
	</sql:query>
	<h1 style="color: red; font-weight: bold;">作业列表</h1>
	<form action="lookwork.do" method="post">
	<table border="1" width="100%">
		<tr>
			<th>作业ID</th>
			<th>作业名称</th>
			<th>作业发布时间</th>
			<th>作业提交时间</th>
			<th>操作</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
		<tr>
		    <td><c:out value="${row.wid}"/></td>
		    <td><c:out value=""/><a href="lookwork.do?wid=${row.wid}" id="">${row.wname}</a></td>
		    <td><c:out value="${row.p_time}"/></td>
		    <td><c:out value="${row.f_time}"/></td>
		    <td><c:out value=""/><a href="lookwork.do?wid=D${row.wid}" id="">删除</a>${msg}</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>