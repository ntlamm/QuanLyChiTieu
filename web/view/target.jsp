<%-- 
    Document   : target
    Created on : Mar 16, 2022, 1:43:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/target.js" type="text/javascript"></script>
<link href="css/target.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <td>STT</td>
                <td>Tên mục tiêu</td>
                <td>Từ(ngày/tháng)</td>
                <td>Đến(ngày/tháng)</td>
                <td>Số tiền(đ)</td>
                <td>Tiết kiệm được</td>
                <td>Ngày còn lại(ngày)</td>
                <td>Đánh giá</td>
                <td>Bình quân mỗi ngày cần tiết kiệm</td>
                <td>Thay đổi</td>
            </tr>
            <c:forEach items="${requestScope.targets}" var="t">
                <tr>
                    <td>${t.tid}</td>
                    <td>${t.tname}</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${t.from}"/></td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${t.to}"/></td>
                    <td><fmt:formatNumber value="${t.tprice}" type="currency"/></td>
                    <td><fmt:formatNumber value="${t.pricesave}" type="currency"/>/<fmt:formatNumber value="${t.tprice}" type="currency"/></td>                    
                    <td>${t.dayleft} ngày</td>
                    <c:if test="${t.pricesave>=t.tprice&&t.dayleft>=0}">
                        <td>Đã đạt được mục tiêu</td>
                    </c:if>
                    <c:if test="${!(t.pricesave>=t.tprice&&t.dayleft>=0)}">
                        <td>Chưa đạt được mục tiêu</td>
                    </c:if>         
                    <c:if test="${t.dayleft<=0||t.tprice<=t.pricesave}">
                        <td><fmt:formatNumber value="0" type="currency"/></td>
                    </c:if> 
                    <c:if test="${t.dayleft>0}">
                        <td><fmt:formatNumber value="${(t.tprice-t.pricesave)/t.dayleft}" type="currency"/></td>
                    </c:if>  
                    <td><a href="chinhsuamuctieu?id=${t.tid}">
                            <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                        <a href="#" onclick="deleteTarget(${t.tid});" >
                            <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="themmuctieu"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
