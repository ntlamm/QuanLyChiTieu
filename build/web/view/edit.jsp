<%-- 
    Document   : edit
    Created on : Mar 7, 2022, 9:49:26 PM
    Author     : Admin
--%>

<%@page import="model.List"%>
<%@page import="model.Type"%>
<%@page import="java.util.ArrayList"%>
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
        <form method="POST" action="chinhsua">
            <input type="hidden" name="cid" value="${requestScope.Rc.cid}"/><br/>
            Ngày/Tháng:<input type="date" name="cdate" value="${requestScope.Rc.cdate}"/><br/>
            Tên:<input type="text" name="cname" value="${requestScope.Rc.cname}"/><br/>
            Số tiền:<input type="text" name="cprice" value="${requestScope.Rc.cprice}"/><br/>
            Ghi chú:<input type="text" name="cnote" value="${requestScope.Rc.cnote}"/><br/>
            Nhóm:<select name="cgroupid">
                <c:forEach items="${requestScope.groups}" var="g">
                <option ${g.getCgroupid() == Rc.getGroup().getCgroupid() ? "selected=\"selected\"" : ""} 
                    value="${g.cgroupid}">${g.cgroupname}</option>
                </c:forEach>
            </select><br/>
            Kiểu(chi/tiêu):<select name="ctypeid">
                <c:forEach items="${requestScope.types}" var="t">
                <option ${t.getCtypeid() == Rc.getType().getCtypeid() ? "selected=\"selected\"" : ""} 
                    value="${t.ctypeid}">${t.ctypename}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Lưu"/>
        </form>      
    </body>
</html>
