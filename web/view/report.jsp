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
<link href="css/report.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <title>Báo cáo</title>
    <nav>LOGO</nav>
</head>
<body>            
    <div class="row">
        <div class="col-sm-2">
            <c:if test="${sessionScope.account==null}">                          
                <div id="bar">
                    <a href="dangnhap"><i class="bi bi-person-fill" style="color:black; font-size: 3rem"></i></a><br/>
                    <h5>Đăng nhập</h5><br/>
                </div>
            </c:if>
            <c:if test="${sessionScope.account!=null}"> 
                <div id="bar">
                    <h6><i class="bi bi-person-check-fill" style="color:black; font-size: 3rem"></i>
                        Chào mừng,${sessionScope.account.username}</h6><br/>
                </div>
            </c:if>
            <div id="bar">
                <a href="baocao"><i class="bi bi-house-door-fill" style="color:black; font-size: 3rem"></i></a><br/>
                <h5>Trang chủ</h5><br/>
            </div>
            <div id="bar">
                <a href="kehoach"><i class="bi bi-clipboard" style="color:black; font-size: 3rem"></i></a><br/>
                <h5>Lập kế hoạch</h5><br/>
            </div>          
            <div id="bar">
                <a href="muctieu"><i class="bi bi-bullseye"style="color:black; font-size: 3rem"></i></a><br/>
                <h5>Lập mục tiêu</h5><br/>
            </div>
        </div>
        <div class="col-sm-10">
            <form id="searchform" action="baocao" method="GET">
                <i class="bi bi-wallet2" style="color: brown"></i> Số dư: <fmt:formatNumber value="${requestScope.Total}" type="currency"/><br/>
                <div id="cashget"><i class="bi bi-cash" style="color: green"></i> Khoản thu: +<fmt:formatNumber value="${requestScope.TotalGet}" type="currency"/></div>
                -<br/>
                <div id="cashpay"><i class="bi bi-cash" style="color: red"></i> Khoản chi: -<fmt:formatNumber value="${requestScope.TotalPay}" type="currency"/></div>
                ___________________________________<br/>
                <fmt:formatNumber value="${requestScope.Total}" type="currency"/><br/>
                <div id="kieu">
                    Kiểu (chi/tiêu):<select name="typeid" onchange="submitSearchForm();">
                        <option value="-1">-----     Tất cả     -----</option>
                        <c:forEach items="${requestScope.types}" var="t">
                            <option ${(t.ctypeid==requestScope.typeid)?"selected=\"selected\"":"" } 
                                value="${t.ctypeid}">-----     ${t.ctypename}     -----</option>
                        </c:forEach>                
                    </select>
                </div>
            </form>
            <c:if test="${requestScope.lists.size()>0}">
                <div id="table" class="col-sm-8">
                    <table border="0px">
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
                                <td><a href="chinhsua?id=${l.cid}">
                                        <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                    <a href="#" onclick="deleteRecord(${l.cid});" >
                                        <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                                </td>
                            </tr>        
                        </c:forEach>
                    </table>
                </c:if>                 
                <c:if test="${requestScope.lists.size() == 0}">
                    <div id="table" class="col-sm-8"> 
                        <h5>Không có bản ghi nào!</h5>
                    </c:if>
                    <br/>                   
                    <a href="them"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

