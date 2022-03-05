/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function login(Object){
    if(Object==null){
        window.alert("Sai tài khoản hoặc mật khẩu!");
        window.location.href="login";
    }else{
        window.alert("Đăng nhập thành công!");       
    }
}

