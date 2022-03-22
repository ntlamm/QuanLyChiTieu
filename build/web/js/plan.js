/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function check(){
    var p1 = document.getElementsByTagName("input")[3].value;
    var p2 = document.getElementsByTagName("input")[4].value;
    var p3 = document.getElementsByTagName("input")[5].value;  
    if(p1==''||p2==''||p3==''){   
        alert("Phải nhập đầy đủ các thông tin!");
        return false;
    }   
}

