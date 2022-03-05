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


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function submitSearchForm() {
                document.getElementById("searchform").submit();
            }
            function deleteRecord(id) {
                result = confirm("Are you sure?");
                if (result) {
                    window.location.href = "delete?id=" + id;
                }
            }
        </script>

    </head>
    <body>
        <form id="searchform" action="baocao" method="GET">
            Department:<select name="typeid" onchange="submitSearchForm();">
                <option value="-1">-----Chọn kiểu (chi/tiêu)----</option>
                <c:forEach items="${requestScope.types}" var="t">
                    <option ${(t.ctypeid==requestScope.typeid)?"selected=\"selected\"":"" } 
                        value="${t.ctypeid}">${t.ctypename}</option>
                </c:forEach>                
            </select>
        </form>
        <c:if test="${requestScope.lists.size()>0}">
            <table border="1px">
                <tr>
                    <td>STT</td>
                    <td>Ngày/Tháng</td>
                    <td>Tên</td>
                    <td>Giá(đ)</td>
                    <td>Ghi chú</td>
                    <td>Loại chi tiêu</td>
                </tr>
                <c:forEach items="${requestScope.lists}" var="l">
                    <tr>
                        <td>${l.cid}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${l.cdate}" /></td>
                        <td>${l.cname}</td>
                        <td>${l.cprice}</td>
                        <td>${l.cnote}</td>
                        <td>${l.type.ctypename}</td>
                        <td><a href="edit?id=${l.cid}">Chỉnh sửa</a>
                            <a href="" onclick="deleteRecord(${l.cid});" >Xóa</a>
                        </td>
                    </tr>        
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.lists.size() == 0}">
            Không có bản ghi nào!
        </c:if>
        <a href="insert">Insert</a>
    </body>
</html>
