/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Delete(id, href, text,stt) {
    result = confirm("Bạn có chắc muốn xóa " + text + " số " + stt + " ?");
    if (result) {
        window.location.href = "" + href + "?id=" + id;
    }
}

