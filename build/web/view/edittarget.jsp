<%-- 
    Document   : edittarget
    Created on : Mar 16, 2022, 5:56:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="chinhsuamuctieu" method="POST">
            <input type="hidden" name="tid" value="${requestScope.target.tid}"/><br/> 
            Tên mục tiêu: <input type="text" name="tname" value="${requestScope.target.tname}"/><br/> 
            Từ(ngày/tháng): <input type="date" name="from" value="${requestScope.target.from}"/><br/>  
            Đến(ngày/tháng): <input type="date" name="to" value="${requestScope.target.to}"/><br/>            
            Số tiền(đ): <input type="text" name="tprice" value="${requestScope.target.tprice}"/><br/>                     
            <input type="submit" value="Lưu"/> 
        </form>
    </body>
</html>
