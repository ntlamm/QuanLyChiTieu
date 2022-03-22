<%-- 
    Document   : plan
    Created on : Mar 14, 2022, 1:42:07 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/delete.js" type="text/javascript"></script>
<link href="css/plan.css" rel="stylesheet" type="text/css"/>
<link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
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
        <div class="row" style="width: 100%;">
            <div style="width: 20%;">
                <%@include file="sideBar.jsp" %>
            </div>
            <div style="width: 80%">
                <%@include file="navBar.jsp" %>                                                                                      
                <div style="margin-left:20px;">
                    <div style="padding-top: 50px">
                        <h5><p class="font-weight-bold"><i class="bi bi-wallet2" style="color: brown"></i> Tổng ngân sách: <fmt:formatNumber value="${requestScope.budget}" type="currency"/></p></h5><br/>
                        <h5><div id="cashpay" style="color: red"><i class="bi bi-cash" ></i> Đã chi: 
                                -<fmt:formatNumber value="${requestScope.TotalPay}" type="currency"/>
                            </div></h5>
                    </div>
                    <h4 style="text-align: center;padding:20px"><p class="font-weight-bold">Bảng kế hoạch</p></h4>
                    <h5 class="text-danger" style="text-align: center">${requestScope.tbao}<h5/>       
                        <c:if test="${requestScope.plans.size()>0}">
                            <table class="table table-striped" style="text-align: center"> 
                                <thead class="thead-light">
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Từ(ngày/tháng)</th>
                                        <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Đến(ngày/tháng)</th>                                                     
                                        <th scope="col"><i class="bi bi-bag-fill"></i> Nhóm</th>
                                        <th scope="col"><i class="bi bi-clipboard-fill"></i> Mô tả</th>
                                        <th scope="col"><i class="bi bi-coin"></i> Ngân sách bỏ ra</th>                                 
                                        <th scope="col">Thay đổi</th>
                                    </tr> 
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.plans}" var="p">
                                        <tr>
                                            <th scope="row">${p.stt}</th>
                                            <td><p class="font-weight-bold" ><fmt:formatDate pattern="dd-MM-yyyy" value="${p.from}"/></p></td>
                                            <td><p class="font-weight-bold" ><fmt:formatDate pattern="dd-MM-yyyy" value="${p.to}"/></p></td>                   
                                            <td>${p.group.cgroupname}</td>
                                            <td>${p.group.cgroupnote}</td>
                                            <td><p class="font-weight-bold" ><fmt:formatNumber value="${p.pprice}" type="currency"/></p></td>
                                            <td><a href="chinhsuakehoach?id=${p.pid}">
                                                    <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                                <a style="margin-left: 10px;" href="#" onclick="Delete(${p.pid}, 'xoakehoach', 'kế hoạch',${p.stt});" >
                                                    <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>                           
                        </c:if>
                        <c:if test="${requestScope.plans.size()==0}">
                            <h5 style="text-align: center"><p class="font-weight-bold">Không có kế hoạch nào!</p></h5>
                        </c:if>
                        <h4 style="text-align: center;padding: 20px;"><p class="font-weight-bold">Thống kê từng kế hoạch</p></h4>                    
                        <c:if test="${requestScope.plans.size()>0}">                           
                            <c:forEach items="${requestScope.plans}" var="p">
                                <table class="table table-striped">
                                    <thead class="thead-light">                                    
                                    <th scope="col" style="width: 35%"><h5><p class="font-weight-bold"><i class="bi bi-bag-fill"></i> Nhóm</p></h5></th>
                                    <th scope="col"><h5><p class="font-weight-bold"><i class="bi bi-clipboard-fill"></i> Thống kê</p></h5></th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="col"><h5><p class="font-weight-bold">${p.group.cgroupname}</p></h5></th>
                                            <th scope="col">Đã chi <fmt:formatNumber value="${p.paypprice}" type="currency" /> / <fmt:formatNumber value="${p.pprice}" type="currency"/> 
                                                (<fmt:formatNumber type="number" minFractionDigits="0" maxFractionDigits="2" value="${p.paypprice/p.pprice*100}" />%) Ngân sách bỏ ra
                                            </th>
                                        </tr>  
                                        <c:if test="${p.dayleft>0}">
                                            <tr>
                                                <td></td>
                                                <td>Còn lại: ${p.dayleft} ngày</td>
                                            </tr>
                                            <c:if test="${p.paypprice<p.pprice}"> 
                                                <tr>
                                                    <td></td>
                                                    <td>Dự chi mỗi ngày(Dự kiến): <fmt:formatNumber value="${(p.pprice-p.paypprice)/p.dayleft}" type="currency"/></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>Đánh giá: Chưa vượt mốc</td>
                                                </tr>
                                            </c:if>
                                            <c:if test="${p.paypprice>=p.pprice}"> 
                                                <tr>
                                                    <td></td>
                                                    <td>Dự chi mỗi ngày(Dự kiến): <fmt:formatNumber value="0" type="currency"/></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>Đánh giá: Đã vượt mốc <fmt:formatNumber value="${(p.paypprice-p.pprice)}" type="currency"/> ngân sách quy định</td>               
                                                </tr>
                                            </c:if>
                                            <tr>
                                                <td></td>
                                                <td>Bình quân mỗi ngày chi(Thực tế): <fmt:formatNumber value="${p.paypprice/p.daypass}" type="currency"/></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td><h5 class="text-success">Kế hoạch chưa đến hạn</h5></td>
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
                                                    <td>Dự chi mỗi ngày(Dự kiến): <fmt:formatNumber value="0" type="currency"/></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>Đánh giá: Chưa vượt mốc</td>
                                                </tr>
                                            </c:if>
                                            <c:if test="${p.paypprice>=p.pprice}">
                                                <tr>
                                                    <td></td>
                                                    <td>Dự chi mỗi ngày(Dự kiến): <fmt:formatNumber value="0" type="currency"/></td>
                                                <tr>
                                                    <td></td>
                                                    <td>Đã vượt mốc: <fmt:formatNumber value="${(p.paypprice-p.pprice)}" type="currency"/> ngân sách quy định</td>               
                                                </tr>
                                            </c:if>
                                            <tr>
                                                <td></td>
                                                <td>Bình quân mỗi ngày chi(Thực tế): <fmt:formatNumber value="${p.paypprice/p.daypass}" type="currency"/></td>
                                            <tr>
                                                <td></td>
                                                <td><h5 class="text-danger">Kế hoạch đã hết hạn</h5></td>
                                            </tr>
                                        </c:if>                                        
                                    </tbody> 
                                </table>
                                <br/>
                            </c:forEach>                           
                        </c:if>
                        <c:if test="${requestScope.plans.size()==0}">
                            <h5 style="text-align: center"><p class="font-weight-bold">Không có thống kê nào!</p></h5>
                        </c:if>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
