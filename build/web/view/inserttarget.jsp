<%-- 
    Document   : inserttarget
    Created on : Mar 16, 2022, 6:12:18 PM
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
        <form action="themmuctieu" method="POST">
            Tên mục tiêu: <input type="text" name="tname" /><br/> 
            Từ(ngày/tháng): <input type="date" name="from" /><br/>  
            Đến(ngày/tháng): <input type="date" name="to" /><br/>            
            Số tiền(đ): <input type="text" name="tprice" /><br/>                     
            <input type="submit" value="Lưu"/> 
        </form>
    </body>
</html>
