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
<title>作业详细列表界面</title>
</head>
<body >
	<!--JDBC 驱动名及数据库 URL 数据库的用户名与密码，需要根据自己的设置useUnicode=true&characterEncoding=utf-8 防止中文乱码-->
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    	 url="jdbc:mysql://localhost:3306/no6_userdb?useUnicode=true&characterEncoding=utf-8"
    	 user="root"  password="123456"/>
	<sql:query dataSource="${snapshot}" var="result">
	SELECT * from t_works WHERE WID = ?;
	<sql:param value="${wid}" />
	</sql:query>
	<h1 style="margin-left: 10px; color: red">${wid}作业详细信息</h1>
	<form action="detailwork.do" method="post">
	<!-- <input type='submit' name='btn1' value='查看'/> -->
	<table ><!-- border="1" width="100%" -->
		<c:forEach var="row" items="${result.rows}" >
		<tr>
			<th>作业编号：</th>
			<td><c:out value="${row.wid}"/></td>
		</tr>
		
		<tr>
			<th>作业名称：</th>
			<td><c:out value="${row.wname}"/></td>
		</tr>
		<tr>
			<th>作业内容：</th>
			<td><c:out value="${row.wcontent}"/></td>
		</tr>
		<tr>
			<th>作业发布时间：</th>
			<td><c:out value="${row.p_time}"/></td>
		</tr>
		<tr>
			<th>作业提交时间：</th>
			<td><c:out value="${row.f_time}"/></td>
		</tr>
		<tr>
		    <td ><c:out value=""/><input type='submit' name='btn' value='返回' style="margin-left: 100px;"/></td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>