/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function submitSearchForm() {
    document.getElementById("searchform").submit();
}

function deleteRecord(id) {
    result = confirm("Bạn có chắc muốn xóa bản ghi số " + id + " ?");
    if (result) {
        window.location.href = "xoa?id=" + id;
    }
}
