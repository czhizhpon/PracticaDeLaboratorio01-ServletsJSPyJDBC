/**
 * 
 */

function hideNotice(){
    document.getElementById("main_notice").classList.add("e_hidden");
}

function showNotice(notice, notice_type){
    document.getElementById("main_notice").classList = '';
    document.getElementById("main_notice").classList.add("notice_container");
    document.getElementById("main_notice").classList.add(notice_type);
    document.getElementById("notice").innerHTML =  notice;
}

function isEmpty(value, error_message){
    if (value == ""){
        showNotice(error_message, "bg-danger");
        return true;
    }
    return false;
}

function getXMLPostRequest(url, post_data, action_function){
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open('POST', url, true);
	xmlhttp.onreadystatechange = action_function;
	var formData = new FormData(post_data);
    xmlhttp.send(formData);
}

function getXMLRequest(url, action_function){
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open('GET', url, true);
	xmlhttp.onreadystatechange = action_function;
    xmlhttp.send();
}

function createBillDetail(){
	
}

function updateProducts(pro_id){
    var name = document.getElementById("name" + pro_id).value;
    getXMLRequest("UpdateProduct?pro_id=" + pro_id + "&pro_name=" + name, function(){
        if (this.readyState == 4 && this.status == 200) {
            location.href = "/sgrc/ProductList";
        }
    });
    console.log(amount);
}