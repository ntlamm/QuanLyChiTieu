/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function check(){
    var p1 = document.getElementsByTagName("input")[0].value;
    var p2 = document.getElementsByTagName("input")[1].value;
    var p3 = document.getElementsByTagName("input")[2].value;
    var p4 = document.getElementsByTagName("input")[3].value;   
    if(p1==''||p2==''||p3==''||p4==''){   
        alert("Phải nhập đầy đủ các thông tin!");
        return false;
    }   
}
