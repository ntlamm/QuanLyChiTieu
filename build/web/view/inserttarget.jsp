<%-- 
    Document   : inserttarget
    Created on : Mar 16, 2022, 6:12:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/sidebar.css" rel="stylesheet" type="text/css"/>
<link href="css/form.css" rel="stylesheet" type="text/css"/>
<script src="js/target.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                <div class="row d-flex justify-content-center">
                    <div class="col-md-5">
                        <form role="form" method="POST" action="themmuctieu" onsubmit="return check()">
                            <h2 style="text-align: center"><i class="bi bi-bullseye" style=" font-size:2rem"></i> Chỉnh sửa mục tiêu</h2>
                            <div class="form-group">
                                <h5><i class="bi bi-chat-dots-fill"></i> Tên mục tiêu</h5>
                                <input type="text" class="form-control"  placeholder="Nhập tên mục tiêu" name="tname" />                                                         
                            </div>
                            <div class="form-group">
                                <h5><i class="bi bi-calendar-date-fill"></i> Từ(ngày/tháng)</h5>
                                <input type="date" class="form-control" name="from" />                                                            
                            </div>
                            <div class="form-group">
                                <h5><i class="bi bi-calendar-month-fill"></i> Đến(ngày/tháng)</h5>
                                <input type="date" class="form-control" name="to" />                                                            
                            </div>
                            <div class="form-group">
                                <h5><i class="bi bi-cash-coin"></i> Số tiền(đ)</h5>
                                <input type="number" name="tprice" class="form-control" placeholder="Nhập số tiền" />                                                         
                            </div>                                                       
                            <p class="text-center"><input id="button" type="submit" value="Lưu"/></p>
                            <p class="text-center"><a href="muctieu" style="color: black"><i class="bi bi-arrow-return-left" ></i>Trở về</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
