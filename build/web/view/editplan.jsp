<%-- 
    Document   : editplan
    Created on : Mar 15, 2022, 2:29:44 PM
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
        <form action="chinhsuakehoach" method="POST">
            <input type="hidden" name="pid" value="${requestScope.plan.pid}"/><br/>
            <c:forEach items="${requestScope.groups}" var="g">           
                <c:if test="${g.cgroupid==requestScope.plan.group.cgroupid}">
                    Nhóm:${g.cgroupname}<input type="hidden" name="cgroupid" value="${g.cgroupid}"/><br/>
                    Mô tả:${g.cgroupnote}<input type="hidden"/><br/> 
                </c:if>  
            </c:forEach>                   
            Từ(ngày/tháng):<input type="date" name="from" value="${requestScope.plan.from}"/><br/>  
            Đến(ngày/tháng):<input type="date" name="to" value="${requestScope.plan.to}"/><br/>            
            Ngân sách bỏ ra(đ):<input type="text" name="pprice" value="${requestScope.plan.pprice}"/><br/>                     
            <input type="submit" value="Lưu"/> 
        </form>
    </body>
</html>
