/**
 * 
 */
 
 function isDecimalKey(txt, evt) {
      var charCode = (evt.which) ? evt.which : evt.keyCode;
      if (charCode == 46) {
        if (txt.value.indexOf('.') === -1) {
          return true;
        } else {
          return false;
        }
      } else {
        if (charCode > 31 &&
          (charCode < 48 || charCode > 57))
          return false;
      }
      return true;
}

function isNumberKey(txt, evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
      
	if (charCode > 31 && (charCode < 48 || charCode > 57)){
          return false;
  	}
  	
  	return true;
}

// Product Register Validations
$(function(){
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
	  	return arg !== value;
	 }, "Seleccione una opción");

	$("#product-form").validate({
		rules:{
			pro_name: {
				required: true
			},
			pro_stock: {
				required: true
			},
			pro_price:{
				required: true
			}, 
			cat_id:{
				valueNotEquals: "NaN"
			}
		},
		messages: {
			pro_name: "Ingrese un nombre",
			pro_stock: "Ingrese un stock",
			pro_price: {
				required: "Ingrese un precio",
				step:"Ingrese un valor con 2 decimales"
			},
			cat_id: {
				valueNotEquals: "Seleccione una Categoría"
			}
		}
	});
});

function valid(f){
	var isvalid = f.valid();
	return isvalid;
}

function createProduct(f_id){
	var form = $("#" + f_id);
	if(valid(form)){
		$.post("/sgrc/CreateProduct", form.serialize(), function(res, est, jqXHR){
			var msg = res.split("&", 2);
			showNotice(msg[0], msg[1]);
			jQuery('#table_product').load('/sgrc/ListProduct #table_content');
		});
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}

function readProduct(pro_id) {
	$.get("/sgrc/ReadProduct?pro_id="+pro_id, function(res){
			location.href = "/sgrc/ListProduct";
		});
}

function updateProduct(f_id) {
	var form = $("#" + f_id);
	if(valid(form)){
		$.post("/sgrc/UpdateProduct", form.serialize(), function(res, est, jqXHR){
			var msg = res.split("&", 2);
			
			//jQuery('#table_product').load('/sgrc/ListProduct #table_content');
			if(msg[1] == "e_notice_error"){
				showNotice(msg[0], msg[1]);
			} else if (msg[1] == "e_notice_sucess"){
				location.href = "/sgrc/ListProduct"
			}
			
		});
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}

function deleteProduct(pro_id, d){
	$.get("/sgrc/DeleteProduct?pro_id=" + pro_id + "&pro_deleted=" + d, function(res){
			var msg = res.split("&", 2);
			showNotice(msg[0], msg[1]);
			jQuery('#table_product').load('/sgrc/ListProduct #table_content');
		});
}


