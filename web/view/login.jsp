<%-- 
    Document   : login
    Created on : Jan 20, 2022, 10:34:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="js/login.js" type="text/javascript"></script>
<link href="css/form.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <title>Đăng nhập</title>
    </head> 
    <body>
        <div class="row d-flex justify-content-center">
            <div class="col-md-4">
                <form role="form" action="dangnhap" method="POST" onsubmit="return login()">
                    <h2 style="text-align: center"><i class="bi bi-key-fill" style=" font-size:3rem"></i>Đăng Nhập</h2>
                    <p class="text-danger" style="text-align: center">${requestScope.tbao}</p>
                    <div class="form-group">
                        <h5><i class="bi bi-people-fill"></i>Tài khoản</h5>
                        <input type="text" class="form-control" placeholder="Nhập tài khoản" name="user">
                    </div>
                    <div class="form-group">
                        <h5><i class="bi bi-lock-fill"></i>Mật khẩu</h5>
                        <input type="password" class="form-control" placeholder="Nhập mật khẩu" name="pass">
                    </div>
                    <p class="text-center"><input id="button" type="submit" value="Đăng nhập"/></p>
                    <p class="text-center"><a href="baocao" style="color: black"><i class="bi bi-arrow-return-left" ></i>Trở về trang chủ</a></p>
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
