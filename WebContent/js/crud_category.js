/**
 * 
 */

$(function(){
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
	  	return arg !== value;
	 }, "Seleccione una opción");

	$("#category-form").validate({
		rules:{
			cat_name: {
				required: true
			}
		},
		messages: {
			cat_name: "Ingrese el nombre"
		}
	});
});

function valid(f){
	var isvalid = f.valid();
	return isvalid;
}

function createCategory(f_id){
	var form = $("#" + f_id);
	if(valid(form)){
		$.post("/sgrc/CreateCategory", form.serialize(), function(res, est, jqXHR){
			var msg = res.split("&", 2);
			showNotice(msg[0], msg[1])
		});
		// Ejemplo de los mensajes que tiene que regresar del Servlet
		var res = "Se registró correctamente&e_notice_sucess"
		var msg = res.split("&", 2);
		showNotice(msg[0], msg[1])
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}