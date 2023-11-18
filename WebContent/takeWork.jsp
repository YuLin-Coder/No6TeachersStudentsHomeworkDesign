<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>布置作业</title>
</head>
<body onload="">
	<form action="takework.do" method="post" style="border: 2px solid black; width: 320px">
    <p style="color: red; font-weight: bold; font-size: 25px;">布置作业</p>
      <table>
         <tr>
            <td>作业名称：</td>
            <td><input type="text" name="wname" id="" style="width: 190px"/></td>
            <td></td>
         </tr>
         <tr>
            <td>作业内容：</td>
            <td><textarea name="wcontent" cols="17" rows="7"></textarea></td>
            <td></td>
         </tr>
                  
         <tr>
            <td>提交时间：</td>
            <td><input type="text" name="f_time" id="" style="width: 190px"/>
            <td></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" name="btn" value="提交"/>${msg}</td>
            <td></td>
         </tr>
      </table>
    </form>
</body>
</html>