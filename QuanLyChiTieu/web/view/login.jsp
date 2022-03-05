<%-- 
    Document   : login
    Created on : Jan 20, 2022, 10:34:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/login.js" type="text/javascript">
    
</script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Đăng Nhập</h1>
        <form action="dangnhap" method="POST">
            Tên tài khoản:<input type="text" name="user" /><br/>
            Mật khẩu:<input type="password" name="pass" /><br/>
            <input type="submit" value="Đăng nhập"/>            
        </form>
    </body>
</html>
