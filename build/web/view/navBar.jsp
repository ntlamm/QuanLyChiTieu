<%-- 
    Document   : navBar
    Created on : Mar 20, 2022, 5:35:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #cccccc;width: 101.25%;">               
            <h5><p class="font-weight-bold"><i class="bi bi-piggy-bank-fill" style="color: #cc6600;font-size: 2rem;" ></i> Quản lý chi tiêu <i class="bi bi-currency-exchange" style="color: #cc9900;font-size: 2rem;"></i></p></h5>
            <a style="color: black;margin-left: 10px;" class="nav-link" href="baocao"><i class="bi bi-house-door-fill" style="font-size: 1.5rem"></i> Trang chủ</a>
            <a style="color: black" class="nav-link" href="kehoach"><i class="bi bi-clipboard-data"></i> Các kế hoạch</a>
            <a style="color: black" class="nav-link" href="muctieu"><i class="bi bi-graph-up-arrow"></i> Các mục tiêu</a>
            <a style="color: black" class="nav-link" href="sono"><i class="bi bi-cash-coin"></i> Sổ nợ</a>
            <c:if test="${sessionScope.account!=null}">
                <div class="nav-item dropdown" style="margin-left: 220px;">
                    <h6>
                        <a style="color: black;" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi bi-person-lines-fill" ></i> Xin chào, ${sessionScope.account.username}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="margin-left:10px;">
                            <a class="dropdown-item" href="dangxuat"><i class="bi bi-box-arrow-left"></i> Đăng xuất</a>
                        </div>
                    </h6>
                </div>
            </c:if>
            <c:if test="${sessionScope.account==null}">                   
                <div class="nav-item dropdown" style="margin-left: 220px;">
                    <h6>
                        <a style="color: black" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi bi-person-workspace"></i> Bạn chưa đăng nhập
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="margin-left:30px;">
                            <a class="dropdown-item" href="dangnhap"><i class="bi bi-box-arrow-right"></i> Đăng nhập</a>
                        </div>
                    </h6>
                </div> 
            </c:if>
        </nav>
    </body>
</html>
