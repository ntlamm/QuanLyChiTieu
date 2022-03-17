<%-- 
    Document   : plan
    Created on : Mar 14, 2022, 1:42:07 PM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/plan.js" type="text/javascript"></script>
<link href="css/plan.css" rel="stylesheet" type="text/css"/>
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
        <h5>${requestScope.tbao}<h5/>
            <table >
                <c:forEach items="${requestScope.groups}" var="g">
                    <tr>
                        <td>${g.cgroupname}</td>
                        <td><a href="themkehoach?id=${g.cgroupid}"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a></td>
                    </tr>
                </c:forEach>
            </table>
            <i class="bi bi-wallet2" style="color: brown"></i> Tổng ngân sách: <fmt:formatNumber value="${requestScope.budget}" type="currency"/><br/>
            <div id="cashpay"><i class="bi bi-cash" style="color: red"></i> Đã chi: -<fmt:formatNumber value="${requestScope.TotalPay}" type="currency"/></div>
            <c:if test="${requestScope.plans.size()>0}">
                <table border="1px">
                    <tr>
                        <td>STT</td>                   
                        <td>Từ(ngày/tháng)</td>
                        <td>Đến(ngày/tháng)</td>                   
                        <td>Nhóm</td>
                        <td>Mô tả</td>
                        <td>Ngân sách bỏ ra(đ)</td>
                        <td>Thay đổi</td>
                    </tr>
                    <c:forEach items="${requestScope.plans}" var="p" >
                        <tr>
                            <td>${p.pid}</td>                   
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${p.from}"/></td>
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${p.to}"/></td>                   
                            <td>${p.group.cgroupname}</td>
                            <td>${p.group.cgroupnote}</td>
                            <td><fmt:formatNumber value="${p.pprice}" type="currency"/></td>
                            <td><a href="chinhsuakehoach?id=${p.pid}">
                                    <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                <a href="#" onclick="deletePlan(${p.pid});" >
                                    <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                            </td>
                        </tr>
                    </c:forEach> 
                </table>
                <c:forEach items="${requestScope.plans}" var="p">
                    <table border="1px">
                        <tr>
                            <td>${p.group.cgroupname}</td>
                            <td><fmt:formatNumber value="${p.paypprice}" type="currency"/>/<fmt:formatNumber value="${p.pprice}" type="currency"/> 
                                (<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${p.paypprice/p.pprice*100}" />%) Ngân sách bỏ ra
                            </td>
                        </tr>  
                        <c:if test="${p.dayleft>0}">
                            <tr>
                                <td></td>
                                <td>Còn lại: ${p.dayleft} ngày</td>
                            </tr>
                            <c:if test="${p.paypprice<p.pprice}"> 
                                <tr>
                                    <td></td>
                                    <td>Dự chi mỗi ngày: <fmt:formatNumber value="${(p.pprice-p.paypprice)/p.dayleft}" type="currency"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>Chưa vượt mốc</td>
                                </tr>
                            </c:if>
                            <c:if test="${p.paypprice>=p.pprice}"> 
                                <tr>
                                    <td></td>
                                    <td>Dự chi mỗi ngày: <fmt:formatNumber value="0" type="currency"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>Đã vượt mốc: <fmt:formatNumber value="${(p.paypprice-p.pprice)}" type="currency"/> ngân sách quy định</td>               
                                </tr>
                            </c:if>
                            <tr>
                                <td></td>
                                <td>Bình quân mỗi ngày chi: <fmt:formatNumber value="${p.paypprice/p.daypass}" type="currency"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>Kế hoạch chưa đến hạn</td>
                            </tr>
                        </c:if>
                        <c:if test="${p.dayleft<=0}">
                            <tr>
                                <td></td>
                                <td>Còn lại: 0 ngày</td>
                            </tr>
                            <c:if test="${p.paypprice<p.pprice}">  
                                <tr>
                                    <td></td>
                                    <td>Dự chi mỗi ngày: <fmt:formatNumber value="0" type="currency"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>Chưa vượt mốc</td>
                                </tr>
                            </c:if>
                            <c:if test="${p.paypprice>=p.pprice}">
                                <tr>
                                    <td></td>
                                    <td>Dự chi mỗi ngày: <fmt:formatNumber value="0" type="currency"/></td>
                                <tr>
                                    <td></td>
                                    <td>Đã vượt mốc: <fmt:formatNumber value="${(p.paypprice-p.pprice)}" type="currency"/> ngân sách quy định</td>               
                                </tr>
                            </c:if>
                            <tr>
                                <td></td>
                                <td>Bình quân mỗi ngày chi: <fmt:formatNumber value="${p.paypprice/p.daypass}" type="currency"/></td>
                            <tr>
                                <td></td>
                                <td>Kế hoạch đã đến hạn</td>
                            </tr>
                        </c:if>
                        </tr><br/>
                    </table>

                </c:forEach>
            </c:if>
            <c:if test="${requestScope.plans.size()==0}">
                <h5>Không có kế hoạch nào!</h5>
            </c:if>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
