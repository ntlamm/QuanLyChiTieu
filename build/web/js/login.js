/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function login(){
    var user = document.getElementsByTagName("input")[0].value;
    var pass = document.getElementsByTagName("input")[1].value;
    if(user==''||pass==''){   
        alert("Tài khoản hoặc mật khẩu đang trống!");
        return false;
    }  
}

