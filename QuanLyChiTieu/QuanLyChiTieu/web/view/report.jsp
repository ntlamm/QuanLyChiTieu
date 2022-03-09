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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      

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
                </tr>
                <%int stt=1;%>
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
    </body>
</html>

