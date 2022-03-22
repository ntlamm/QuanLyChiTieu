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
<link href="css/pagger.css" rel="stylesheet" type="text/css"/>
<link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
<script src="js/pagger.js" type="text/javascript"></script>
<script src="js/delete.js" type="text/javascript"></script>
<script src="js/report.js" type="text/javascript"></script>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <title>Báo cáo</title>       
    </head>
    <body>       
        <div class="row" style="width: 100%">
            <div style="width: 20%">
                <%@include file="sideBar.jsp" %>
            </div>
            <div  style="width: 80%">     
                <%@include file="navBar.jsp" %>
                <div style="margin-top: 50px; margin-left: 20px;">
                    <form id="searchform" action="baocao" method="GET">
                        <h5><p class="font-weight-bold" ><i class="bi bi-wallet2" style="color: brown"></i> Số dư: <fmt:formatNumber value="${requestScope.Total}" type="currency"/></p></h5><br/>
                        <h5><div id="cashget" style="color: green"><i class="bi bi-cash" ></i> Khoản thu: +<fmt:formatNumber value="${requestScope.TotalGet}" type="currency"/></div></h5>
                        -<br/>
                        <h5><div id="cashpay" style="color: red"><i class="bi bi-cash" ></i> Khoản chi: -<fmt:formatNumber value="${requestScope.TotalPay}" type="currency"/></div></h5>
                        <h5>___________________________________</h5><br/>
                        <h5><p class="font-weight-bold" > <fmt:formatNumber value="${requestScope.Total}" type="currency"/></p></h5><br/>                        

                        <h4 style="text-align: center;padding:20px"><p class="font-weight-bold">Bảng chi tiêu</p></h4>

                        <h5><p class="text-center" >Kiểu (chi/tiêu) :<select  style="text-align: center;border-radius: 5px;" name="typeid" onchange="submitSearchForm();">
                                    <option value="-1">-----     Tất cả     -----</option>
                                    <c:forEach items="${requestScope.types}" var="t">
                                        <option ${(t.ctypeid==requestScope.typeid)?"selected=\"selected\"":"" } 
                                            value="${t.ctypeid}">-----     ${t.ctypename}     -----</option>
                                    </c:forEach>                
                                </select></p></h5>                        
                    </form>                        
                    <c:if test="${requestScope.lists.size()>0}">              
                        <table class="table table-striped" style="text-align: center"> 
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Ngày/Tháng</th>
                                    <th scope="col"><i class="bi bi-chat-square-text-fill"></i> Tên</th>
                                    <th scope="col"><i class="bi bi-coin"></i> Số tiền</th>
                                    <th scope="col"><i class="bi bi-clipboard-fill"></i> Ghi chú</th>
                                    <th scope="col"><i class="bi bi-bag-fill"></i> Nhóm</th>
                                    <th scope="col"><i class="bi bi-credit-card-2-back-fill"></i> Loại chi tiêu</th>
                                    <th scope="col">Thay đổi</th>
                                </tr> 
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.lists}" var="l">
                                    <tr>
                                        <th scope="row">${l.stt}</th>
                                        <td><p class="font-weight-bold"><fmt:formatDate pattern="dd-MM-yyyy" value="${l.cdate}"/></p></td>
                                        <td>${l.cname}</td>
                                        <td>
                                            <c:if test="${l.type.ctypeid==1}">
                                                <p style="color: green">+<fmt:formatNumber value="${l.cprice}" type="currency"/></p>
                                            </c:if>
                                            <c:if test="${l.type.ctypeid==2}">
                                                <p style="color: red">-<fmt:formatNumber value="${l.cprice}" type="currency"/></p>
                                            </c:if>
                                        </td>
                                        <td>${l.cnote}</td>
                                        <td>${l.group.cgroupname}</td>
                                        <td><c:if test="${l.type.ctypeid==1}">
                                                <p style="color: green">${l.type.ctypename}</p>
                                            </c:if>
                                            <c:if test="${l.type.ctypeid==2}">
                                                <p style="color: red">${l.type.ctypename}</p>
                                            </c:if>
                                        </td>
                                        <td><a href="chinhsua?id=${l.cid}">
                                                <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                            <a style="margin-left: 10px;" href="#" onclick="Delete(${l.cid}, 'xoa', 'bản ghi',${l.stt});" >
                                                <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a></td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                        <p class="text-center"><a href="them"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a></p>
                            </c:if>                 
                            <c:if test="${requestScope.lists.size() == 0}">
                        <div style="text-align: center;">
                            <h5>Không có bản ghi nào!</h5>
                            <a href="them"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem;"></i></a>
                        </div>
                    </c:if>
                    <br/>                                       
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

