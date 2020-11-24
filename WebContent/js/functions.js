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
    document.getElementById("notice").innerHTML = "<span>" + notice + "</span>";
}

function isEmpty(value, error_message){
    if (value == ""){
        showNotice(error_message, "bg-danger");
        return true;
    }
    return false;
}

function getXMLRequest(url, post_data, action_function){
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open('POST', url, true);
	xmlhttp.onreadystatechange = action_function;
	
/*
    xmlhttp.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            data = xmlhttp.response;
            current_page = [0, 0, 4];
            hiddeLoading();
            print(data);
        }
    };

    xmlhttp.onerror = function(e){
        showNotice("Error API.", "bg-danger");
        //hiddeLoading();
    };
    showLoading();
*/
    xmlhttp.send(post_data);
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

function updateBillDetails(det_id){
    var amount = document.getElementById("quantity" + det_id).value;
    getXMLRequest("UpdateBillDetail?det_id=" + det_id + "&det_amount=" + amount, function(){
        if (this.readyState == 4 && this.status == 200) {
            location.href = "/sgrc/ShoppingList";
        }
    });
    console.log(amount);
}
