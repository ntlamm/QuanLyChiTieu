<%-- 
    Document   : debt
    Created on : Mar 21, 2022, 9:03:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/delete.js" type="text/javascript"></script>
<link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
<link href="css/pagger.css" rel="stylesheet" type="text/css"/>
<script src="js/pagger.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
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
                    <h5><div id="cashpay" style="color: red"><i class="bi bi-cash" ></i> Tổng nợ: 
                            -<fmt:formatNumber value="${requestScope.totalleft}" type="currency"/>
                        </div></h5>
                    <h4 style="text-align: center;padding:20px"><p class="font-weight-bold">Bảng ghi nợ</p></h4>
                    <c:if test="${requestScope.debts.size()>0}">
                        <table class="table table-striped" style="text-align: center">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col"><i class="bi bi-calendar2-date-fill"></i> Ngày/Tháng</th>
                                    <th scope="col"><i class="bi bi-clipboard-fill"></i> Ghi chú</th>
                                    <th scope="col"><i class="bi bi-credit-card-2-back-fill"></i> Tiền nợ</th>
                                    <th scope="col"><i class="bi bi-coin"></i> Đã trả</th>
                                    <th scope="col"><i class="bi bi-coin"></i> Còn lại</th>
                                    <th scope="col">Thay đổi</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.debts}" var="d">
                                    <tr>
                                        <th scope="row">${d.stt}</th>
                                        <td><p class="font-weight-bold"><fmt:formatDate pattern="dd-MM-yyyy" value="${d.debtdate}"/></p></td>
                                        <td>${d.debtname}</td>
                                        <td><p style="color: red">-<fmt:formatNumber value="${d.debtprice}" type="currency"/></p></td>
                                        <td><p style="color: green">+<fmt:formatNumber value="${d.debtpay}" type="currency"/></p></td>
                                        <td><p style="color: red">-<fmt:formatNumber value="${d.debtleft}" type="currency"/></p></td>
                                        <td><a href="chinhsuano?id=${d.debtid}">
                                                <i class="bi bi-wrench" style="color: green; font-size: 1.5rem"></i></a>
                                            <a style="margin-left: 10px;" href="#" onclick="Delete(${d.debtid}, 'xoano', 'bản ghi',${d.stt});" >
                                                <i class="bi bi-trash3-fill" style="color: red;font-size: 1.5rem"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${requestScope.debts.size()==0}">
                        <h5 style="text-align: center"><p class="font-weight-bold">Không có bản ghi nào!</p></h5>
                    </c:if>
                    <p class="text-center"> <a href="themno"><i class="bi bi-plus-circle" style="color: black; font-size: 2rem"></i></a></p>
                </div>
                <h5><p style="text-align: center;margin-left: 20px;margin-top: 50px;">Trang</p></h5>
                <div id="pagger"> </div>
                <script>
                    pagger('pagger',${requestScope.pageindex},${requestScope.totalpage}, 2);
                </script>
            </div>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
