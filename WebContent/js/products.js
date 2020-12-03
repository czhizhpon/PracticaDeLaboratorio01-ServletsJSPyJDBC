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


$(document).ready(function() {
  $('#cat_id').change(function(){
    $("#width_tmp_option").html($('#cat_id option:selected').text()); 
    $(this).width($("#width_tmp_select").width());  
  });
});

function searchProduct(){
	var s = document.getElementById('pro_name').value;
	var cat_id = document.getElementById('cat_id').value;
	var url = "/sgrc/store?s=" + s + "&cat_id=" + cat_id;
	location.href = url;
	//$.get(url, function(res){
		//var msg = res.split("&", 2);
		//showNotice(msg[0], msg[1]);
		//jQuery('#father-load').load(`${url} #child-load`);
	//});
}

function loadNavPage(s, cat_id, current_page, e){
	//e.preventDefault();
	var url = "/sgrc/store?page=" + current_page + "&s=" + s + "&cat_id=" + cat_id;
	console.log('ENTRA')
	location.href = url;
	//$.get(url, function(res){
		//var msg = res.split("&", 2);
		//showNotice(msg[0], msg[1]);
		//jQuery('#father-load').load(`${url} #child-load`);
	//});
}

function createDetail(f_id){
	var form = $("#" + f_id);
	$.post("/sgrc/CreateBillDetail", form.serialize(), function(res){
		var msg = res.split("&", 2);
		showNotice(msg[0], msg[1]);
		//jQuery('#father-load').load('/sgrc/CreateBillDetail #child-load');
	});
	//showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
}

function createIndexDetail(f_id){
	var form = $("#" + f_id);
	$.ajax({
	  async:false
	});
	$.post("/sgrc/CreateBillDetail", form.serialize(), function(res){
		var msg = res.split("&", 2);
		if(msg[1] == "e_notice_sucess"){
			location.href = "ShoppingList";
		} else {
			location.href = "EndSession";
		}
	});
	//showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
}