<%-- 
    Document   : baocao
    Created on : Mar 5, 2022, 4:20:01 PM
    Author     : Admin
--%>

<%@page import="model.List"%>
<%@page import="model.Type"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/report.js" type="text/javascript"></script>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Báo cáo</title>
    </head>
    <body>
        <form id="searchform" action="baocao" method="GET">
            Số dư:<fmt:formatNumber value="${requestScope.Total}" type="currency"/><br/>
            Khoản chi:<fmt:formatNumber value="${requestScope.TotalGet}" type="currency"/><br/>
            -<br/>
            Khoản thu:<fmt:formatNumber value="${requestScope.TotalPay}" type="currency"/><br/>
            ___________________________________<br/>
            <fmt:formatNumber value="${requestScope.Total}" type="currency"/><br/>

            Kiểu (chi/tiêu):<select name="typeid" onchange="submitSearchForm();">
                <option value="-1">-----     Tất cả     -----</option>
                <c:forEach items="${requestScope.types}" var="t">
                    <option ${(t.ctypeid==requestScope.typeid)?"selected=\"selected\"":"" } 
                        value="${t.ctypeid}">-----     ${t.ctypename}     -----</option>
                </c:forEach>                
            </select>
        </form>
        <c:if test="${requestScope.lists.size()>0}">
            <table border="1px">
                <tr>
                    <td>STT</td>
                    <td>Ngày/Tháng</td>
                    <td>Tên</td>
                    <td>Số tiền</td>
                    <td>Ghi chú</td>
                    <td>Nhóm</td>
                    <td>Loại chi tiêu</td>
                    <td>Thay đổi</td>
                </tr>
                <%int stt = 1;%>
                <c:forEach items="${requestScope.lists}" var="l">
                    <tr>
                        <td><%=stt++%></td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${l.cdate}"/></td>
                        <td>${l.cname}</td>
                        <td><fmt:formatNumber value="${l.cprice}" type="currency"/></td>
                        <td>${l.cnote}</td>
                        <td>${l.group.cgroupname}</td>
                        <td>${l.type.ctypename}</td>
                        <td><a href="chinhsua?id=${l.cid}">Chỉnh sửa</a>
                            <a href="#" onclick="deleteRecord(${l.cid});" >Xóa</a>
                        </td>
                    </tr>        
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.lists.size() == 0}">
            Không có bản ghi nào!
        </c:if>
        <br/>
        <a href="them">Thêm</a>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>

