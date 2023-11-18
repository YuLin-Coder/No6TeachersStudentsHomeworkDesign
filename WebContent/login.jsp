<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body onload="">
<!-- 在客户端（浏览器）环境下，"/"代表服务器根目录 -->
    <form action="login.do" method="post"  style="border: 1px solid black; width: 320px">
    <p>用户登录</p>
      <table>
         <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id=""/></td>
            <td>*</td>
         </tr>
         <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd"/></td>
            <td>*</td>
         </tr>
                  
         <tr>
            <td>角色：</td>
            <td><input type="radio" name="role" value="1"/>教师
            <input type="radio" name="role" value="2"/>学生
            <td></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" name="btn" value="登录"/>${msg}</td>
            <td></td>
         </tr>

      
      </table>
    </form>
</body>
</html>