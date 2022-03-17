/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function deleteTarget(id){
    result = confirm("Bạn có chắc muốn xóa mục tiêu số " + id + " ?");
    if (result) {
        window.location.href = "xoamuctieu?id=" + id;
    }
}

