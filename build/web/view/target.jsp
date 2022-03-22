<%-- 
    Document   : target
    Created on : Mar 16, 2022, 1:43:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/delete.js" type="text/javascript"></script>
<link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
<link href="css/pagger.css" rel="stylesheet" type="text/css"/>
<script src="js/pagger.js" type="text/javascript"></script>
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
        <div class="row" style="width: 100%">
            <div style="width: 20%">
                <%@include file="sideBar.jsp" %>
            </div>
            <div style="width: 80%">
                <%@include file="navBar.jsp" %>
                <div style="margin-left: 10px;margin-top: 100px;"> 
                    <h4 style="text-align: center;padding:20px"><p class="font-weight-bold">Bảng mục tiêu</p></h4>
                    <c:if test="${requestScope.targets.size()>0}">
                        <table class="table table-striped" style="text-align: center">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col"><i class="bi bi-chat-square-text-fill"></i> Tên mục tiêu</th>
                                    <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Từ(ngày/tháng)</th>
                                    <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Đến(ngày/tháng)</th>
                                    <th scope="col"><i class="bi bi-coin"></i> Tiết kiệm</th>
                                    <th scope="col"><i class="bi bi-coin"></i> Số tiền(đ)</th>                                                                   
                                    <th scope="col">Thay đổi</th>
                                </tr>
                            </thead> 
                            <tbody>
                                <c:forEach items="${requestScope.targets}" var="t">
                                    <tr>
                                        <th scope="row">${t.stt}</th>
                                        <td>${t.tname}</td>
                                        <td><p class="font-weight-bold"><fmt:formatDate pattern="dd-MM-yyyy" value="${t.from}"/></p></td>
                                        <td><p class="font-weight-bold"><fmt:formatDate pattern="dd-MM-yyyy" value="${t.to}"/></p></td>
                                        <td><p style="color: green">+<fmt:formatNumber value="${t.pricesave}" type="currency"/></p></td>
                                        <td><p class="font-weight-bold"><fmt:formatNumber value="${t.tprice}" type="currency"/></p></td>
                                        <td><a href="chinhsuamuctieu?id=${t.tid}">
                                                <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                                <a style="padding-left: 20px;" href="#" onclick="Delete(${t.tid}, 'xoamuctieu', 'mục tiêu',${t.stt});" >
                                                <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${requestScope.targets.size()==0}">
                        <h5 style="text-align: center"><p class="font-weight-bold">Không có mục tiêu nào!</p></h5>
                    </c:if>
                    <p class="text-center"> <a href="themmuctieu"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a></p>

                    <h4 style="text-align: center;padding: 20px;"><p class="font-weight-bold">Thống kê từng mục tiêu</p></h4>
                    <c:if test="${requestScope.targets.size()>0}">
                        <c:forEach items="${requestScope.targets}" var="t">
                            <table class="table table-striped">
                                <thead class="thead-light">
                                <th scope="col" style="width: 35%"><h5><p class="font-weight-bold"><i class="bi bi-chat-square-text-fill"></i> Tên mục tiêu</p></h5></th>
                                <th scope="col"><h5><p class="font-weight-bold"><i class="bi bi-clipboard-fill"></i> Thống kê</p></h5></th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="col"><h5><p class="font-weight-bold">${t.tname}</p></h5></th>
                                        <td><p class="font-weight-bold">Tiết kiệm được: <fmt:formatNumber value="${t.pricesave}" type="currency"/> / <fmt:formatNumber value="${t.tprice}" type="currency"/></p></td>
                                    </tr>
                                    <c:if test="${t.dayleft>0}">
                                        <tr> 
                                            <td></td>
                                            <td>Ngày còn lại: ${t.dayleft} ngày</td>
                                        </tr>                                   
                                    </c:if>
                                    <c:if test="${t.dayleft<=0}">
                                        <tr> 
                                            <td></td>
                                            <td>Ngày còn lại: 0 ngày</td>
                                        </tr> 
                                    </c:if>
                                    <c:if test="${t.pricesave>=t.tprice&&t.dayleft>=0}">
                                        <tr> 
                                            <td></td>
                                            <td>Đánh giá: Đã đạt được mục tiêu</td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${!(t.pricesave>=t.tprice&&t.dayleft>=0)}">
                                        <tr> 
                                            <td></td>
                                            <td>Đánh giá: Chưa đạt được mục tiêu</td>
                                        </tr>
                                    </c:if>         
                                    <c:if test="${t.dayleft<=0||t.tprice<=t.pricesave}">
                                        <tr> 
                                            <td></td>
                                            <td>Bình quân mỗi ngày cần tiết kiệm: <fmt:formatNumber value="0" type="currency"/></td>
                                        </tr>
                                    </c:if> 
                                    <c:if test="${t.dayleft>0}">
                                        <tr> 
                                            <td></td>
                                            <td>Bình quân mỗi ngày cần tiết kiệm: <fmt:formatNumber value="${(t.tprice-t.pricesave)/t.dayleft}" type="currency"/></td>
                                        </tr>
                                    </c:if>
                                    <c:if test="${t.dayleft>0}">
                                        <tr> 
                                            <td></td>
                                            <td><h5 class="text-success">Mục tiêu chưa đến hạn</h5></td>
                                        </tr>                                   
                                    </c:if>
                                    <c:if test="${t.dayleft<=0}">
                                        <tr> 
                                            <td></td>
                                            <td><h5 class="text-danger">Mục tiêu đã đến hạn</h5></td>
                                        </tr> 
                                    </c:if>
                                </tbody>
                            </table>
                        </c:forEach>
                    </c:if>
                    <c:if test="${requestScope.targets.size()==0}">
                        <h5 style="text-align: center"><p class="font-weight-bold">Không có thống kê nào!</p></h5>
                    </c:if>
                </div>
                <h5><p style="text-align: center;margin-left: 20px;margin-top: 50px;">Trang</p></h5>
                <div id="pagger"> </div>
                <script>
                    pagger('pagger',${requestScope.pageindex},${requestScope.totalpage}, 2);
                </script>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
