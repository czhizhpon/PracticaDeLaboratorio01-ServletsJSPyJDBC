/**
 * 
 */
 
 function isDecimalKey(txt, evt) {
      var charCode = (evt.which) ? evt.which : evt.keyCode;
      if (charCode == 46) {
        //Check if the text already contains the . character
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
		getXMLRequest("/sgrc/CreateUser", form.serialize(), function(){
        	if (this.readyState == 4 && this.status == 200) {
            	var res = xmlhttp.response;
				msg = res.split("&", 2);
				showNotice(msg, "e_notice_sucess")
        	}
    	});
		// Ejemplo de los mensajes que tiene que regresar del Servlet
		var res = "Se registró correctamente&e_notice_sucess"
		var msg = res.split("&", 2);
		showNotice(msg[0], msg[1])
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}
