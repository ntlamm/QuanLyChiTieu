<%-- 
    Document   : insert
    Created on : Mar 7, 2022, 8:40:28 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm</title>
    </head>
    <body>
        <form method="POST" action="them">
            Ngày/Tháng:<input type="date" name="cdate"/><br/>           
            Tên:<input type="name" name="cname"/><br/>
            Số tiền(đ):<input type="text" name="cprice"/><br/>
            Ghi chú:<input type="text" name="cnote"/><br/>
            Nhóm:<select name="cgroupid">
                <c:forEach items="${requestScope.groups}" var="g">
                    <option value="${g.cgroupid}">${g.cgroupname}</option>
                </c:forEach>
            </select><br/>
            Kiểu(chi/tiêu):<select name="ctypeid">
                <c:forEach items="${requestScope.types}" var="t">
                    <option value="${t.ctypeid}">${t.ctypename}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Thêm"/>          
        </form>
    </body>
</html>
