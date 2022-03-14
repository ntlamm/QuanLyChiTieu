/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function deletePlan(id){
    result = confirm("Bạn có chắc muốn xóa bản kế hoạch số " + id + " ?");
    if (result) {
        window.location.href = "xoakehoach?id=" + id;
    }
}

