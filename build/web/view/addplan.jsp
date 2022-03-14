<%-- 
    Document   : addplan
    Created on : Mar 14, 2022, 8:37:08 PM
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
        <form method="POST" action="themkehoach">
            <c:forEach items="${requestScope.groups}" var="g">
                <c:if test="${g.cgroupid==requestScope.id}">
                    Nhóm:${g.cgroupname}<input type="hidden" name="cgroupid" value="${requestScope.id}"/><br/> 
                </c:if>           
            </c:forEach>
            Từ(ngày/tháng):<input type="date" name="from"/><br/>  
            Đến(ngày/tháng):<input type="date" name="to"/><br/>            
            Ngân sách bỏ ra(đ):<input type="text" name="pprice"/><br/>                     
            <input type="submit" value="Lưu"/>          
        </form>
    </body>
</html>
