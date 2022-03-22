<%-- 
    Document   : navBar
    Created on : Mar 20, 2022, 5:33:16 PM
    Author     : Admin
--%>

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
        <div class="wrapper d-flex" >
            <div class="sidebar"> 
                <h5 class="title" style="color: gray;padding-left: 20px">Trạng thái người dùng</h5>
                <ul style="text-align: center">
                    <c:if test="${sessionScope.account!=null}">
                        <h5 style="color: white"><i class="bi bi-person-check-fill" style="font-size: 2rem" ></i> Đã đăng nhập</h5>
                        <li><a href="dangxuat" ><i class="bi bi-box-arrow-in-left"></i> Đăng xuất</a></li>   
                        </c:if>
                        <c:if test="${sessionScope.account==null}">
                        <h5 style="color: white"><i class="bi bi-person-x-fill" style="font-size: 2rem "></i> Chưa đăng nhập</h5>
                        <li><a href="dangnhap"><i class="bi bi-box-arrow-in-right"></i> Đăng nhập</a></li>   
                        </c:if>
                </ul >
                <h5 class="title" style="color: gray;padding-left: 20px">Các trang chính</h5>                   
                <ul style="padding-left: 20px;">
                    <li><a href="baocao"><i class="bi bi-house-door-fill"></i> Trang chủ</a></li>
                    <li class="active">
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="bi bi-clipboard2-check-fill"></i> Kế hoạch</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="kehoach"><i class="bi bi-clipboard-data"></i> Xem các kế hoạch</a>
                            </li>                            
                            <li>                      
                                <a href="#planSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="bi bi-calendar-plus"></i> Thêm kế hoạch</a>
                                <ul class="collapse list-unstyled" id="planSubmenu">
                                    <c:forEach items="${requestScope.groups}" var="g">                                      
                                        <a class="addplan" href="themkehoach?id=${g.cgroupid}">${g.cgroupname}</a>         
                                    </c:forEach> 
                                </ul>                                  
                            </li>                                                                                 
                        </ul>
                    </li>
                    <li><a href="muctieu"><i class="bi bi-graph-up-arrow"></i> Mục tiêu</a></li>
                    <li><a href="sono"><i class="bi bi-cash-coin"></i> Sổ ghi nợ</a></li>
                </ul>
                <h5 class="title" style="color: gray;padding-left: 20px">Liên hệ</h5>
                <ul>
                    <p class="text-center" style="font-size: 14px"><a style="color: white" href="https://www.facebook.com/lam.Peruz">FB: https://www.facebook.com/lam.Peruz</a></p>
                    <p class="text-center" style="color: white;font-size: 14px">Sđt: 0362504733</p>
                    <p class="text-center" style="font-size: 14px"><a style=" color: white" href = "mailto: lamnthe150456@fpt.edu.vn">Email: lamnthe150456@fpt.edu.vn</a></p>
                </ul>
            </div>
        </div> 
    </body>
</html>
