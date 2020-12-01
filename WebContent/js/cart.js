/**
 * 
 */

function isNumberKey(txt, evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
      
	if (charCode > 31 && (charCode < 48 || charCode > 57)){
          return false;
  	}
  	return true;
}

function updateBillDetails(det_id){
    var amount = document.getElementById("det_amount" + det_id);
	var url = "UpdateBillDetail?det_id=" + det_id + "&det_amount=" + amount.value;
    $.get(url, function(res){
		var msg = res.split("&", 2);
		if(msg[1] == "e_notice_warning"){
			showNotice(msg[0], msg[1]);
			amount.classList.add("error");
		} else if(msg[1] == "e_notice_sucess"){
			location.href = "ShoppingList"
		} else{
			amount.classList.add("error");
			showNotice("No se pudo conectar con el Servidor", "e_notice_error");
		}
		//jQuery('#father-load').load(`${url} #child-load`);
	});
}

function deleteBillDetails(det_id){
	var url = "DeleteBillDetail?det_id=" + det_id;
	$.get(url, function(res){
		var msg = res.split("&", 2);
		if(msg[1] == "e_notice_error"){
			showNotice(msg[0], msg[1]);
		} else if(msg[1] == "e_notice_sucess"){
			location.href = "ShoppingList"
		} else{
			showNotice("No se pudo conectar con el Servidor", "e_notice_error");
		}
		//jQuery('#father-load').load(`${url} #child-load`);
	});
}

function updateBillHead(){
	var url = "UpdateBillHead";
	$.get(url, function(res){
		var msg = res.split("&", 2);
		console.log(msg)
		if(msg[1] == "e_notice_error" || msg[1] == "e_notice_warning"){
			showNotice(msg[0], msg[1]);
		} else if(msg[1] == "e_notice_sucess"){
			location.href = "ShoppingList"
		} else{
			showNotice("No se pudo conectar con el Servidor", "e_notice_error");
		}
		//jQuery('#father-load').load(`${url} #child-load`);
	});
}
