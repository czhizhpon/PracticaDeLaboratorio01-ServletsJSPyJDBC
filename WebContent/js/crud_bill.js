/**
 * 
 */
function showDetail(hea_id){
	$.get("/sgrc/ReadBillHead?hea_id=" + hea_id , function(res){
		jQuery('#detail-list').load('/sgrc/bills #detail-content');
		var e = document.getElementById("bill-details");
		e.classList.remove("invisible")
	});
}

function hideDetail(){
	var e = document.getElementById("bill-details");
	e.classList.add("invisible")
}

function searchBill(){
	var s = document.getElementById("email-input").value;
	var url = "/sgrc/bills?s=" + s;
	location.href = url;
}

function updateBill(hea_status, hea_id){
	$.get("/sgrc/RequestBillHead?hea_status=" + hea_status + "&hea_id=" + hea_id, function(res){
		var msg = res.split("&", 2);
		showNotice(msg[0], msg[1]);
		jQuery('#bill-list').load('/sgrc/bills #bill-content');
	});
}